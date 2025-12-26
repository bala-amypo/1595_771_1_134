package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository dailySymptomLogRepository;
    private final PatientProfileRepository patientProfileRepository;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertRecordRepository clinicalAlertRecordRepository;

    // ✅ ALL REQUIRED DEPENDENCIES INJECTED
    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository dailySymptomLogRepository,
            PatientProfileRepository patientProfileRepository,
            RecoveryCurveService recoveryCurveService,
            DeviationRuleService deviationRuleService,
            ClinicalAlertRecordRepository clinicalAlertRecordRepository
    ) {
        this.dailySymptomLogRepository = dailySymptomLogRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertRecordRepository = clinicalAlertRecordRepository;
    }

    // 🔹 CREATE DAILY LOG
    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        Long patientId = log.getPatientId();
        LocalDate logDate = log.getLogDate();

        // 1️⃣ Patient must exist
        PatientProfile patient = patientProfileRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        // 2️⃣ Only one log per patient per day
        dailySymptomLogRepository
                .findByPatientIdAndLogDate(patientId, logDate)
                .ifPresent(existing -> {
                    throw new IllegalArgumentException(
                            "Daily log already exists for this patient");
                });

        // 3️⃣ Save log
        DailySymptomLog savedLog =
                dailySymptomLogRepository.save(log);

        // 4️⃣ Determine recovery day
        long recoveryDay = ChronoUnit.DAYS.between(
                patient.getCreatedAt().toLocalDate(),
                logDate
        );

        // 5️⃣ Get expected recovery curve
        List<RecoveryCurveProfile> curves =
                recoveryCurveService.getCurveForSurgery(
                        patient.getSurgeryType());

        RecoveryCurveProfile expectedCurve = curves.stream()
                .filter(c -> c.getDayNumber() == (int) recoveryDay)
                .findFirst()
                .orElse(null);

        // 6️⃣ Apply deviation rules
        if (expectedCurve != null) {

            List<DeviationRule> rules =
                    deviationRuleService.getActiveRules();

            for (DeviationRule rule : rules) {

                boolean violated = false;

                if ("PAIN".equals(rule.getParameter())) {
                    violated = log.getPainLevel() != null &&
                            log.getPainLevel() >
                                    expectedCurve.getExpectedPainLevel()
                                            + rule.getThreshold();
                }

                if (violated) {
                    ClinicalAlertRecord alert =
                            ClinicalAlertRecord.builder()
                                    .patientId(patientId)
                                    .logId(savedLog.getId())
                                    .alertType("PAIN_SPIKE")
                                    .severity(rule.getSeverity())
                                    .message("Pain deviation detected")
                                    .resolved(false)
                                    .build();

                    // ✅ SAVE ALERT DIRECTLY
                    clinicalAlertRecordRepository.save(alert);
                }
            }
        }

        return savedLog;
    }

    // 🔹 UPDATE DAILY LOG
    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updatedLog) {

        DailySymptomLog existing =
                dailySymptomLogRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Log not found"));

        // Patient must exist
        patientProfileRepository.findById(existing.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        existing.setPainLevel(updatedLog.getPainLevel());
        existing.setMobilityLevel(updatedLog.getMobilityLevel());
        existing.setFatigueLevel(updatedLog.getFatigueLevel());
        existing.setAdditionalNotes(updatedLog.getAdditionalNotes());

        return dailySymptomLogRepository.save(existing);
    }

    // 🔹 GET LOGS BY PATIENT
    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {

        patientProfileRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        return dailySymptomLogRepository.findByPatientId(patientId);
    }
}
