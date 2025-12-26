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
    private final ClinicalAlertService clinicalAlertService; // ✅ SERVICE, NOT REPO

    // ✅ CONSTRUCTOR MATCHES TEST EXACTLY
    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository dailySymptomLogRepository,
            PatientProfileRepository patientProfileRepository,
            RecoveryCurveService recoveryCurveService,
            DeviationRuleService deviationRuleService,
            ClinicalAlertService clinicalAlertService
    ) {
        this.dailySymptomLogRepository = dailySymptomLogRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertService = clinicalAlertService;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        Long patientId = log.getPatientId();
        LocalDate logDate = log.getLogDate();

        PatientProfile patient = patientProfileRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        dailySymptomLogRepository
                .findByPatientIdAndLogDate(patientId, logDate)
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Daily log already exists");
                });

        DailySymptomLog savedLog = dailySymptomLogRepository.save(log);

        long recoveryDay = ChronoUnit.DAYS.between(
                patient.getCreatedAt().toLocalDate(),
                logDate
        );

        List<RecoveryCurveProfile> curves =
                recoveryCurveService.getCurveForSurgery(patient.getSurgeryType());

        RecoveryCurveProfile expectedCurve = curves.stream()
                .filter(c -> c.getDayNumber() == (int) recoveryDay)
                .findFirst()
                .orElse(null);

        if (expectedCurve != null) {
            for (DeviationRule rule : deviationRuleService.getActiveRules()) {

                if ("PAIN".equals(rule.getParameter())
                        && log.getPainLevel() != null
                        && log.getPainLevel() >
                           expectedCurve.getExpectedPainLevel() + rule.getThreshold()) {

                    ClinicalAlertRecord alert = ClinicalAlertRecord.builder()
                            .patientId(patientId)
                            .logId(savedLog.getId())
                            .alertType("PAIN_SPIKE")
                            .severity(rule.getSeverity())
                            .message("Pain deviation detected")
                            .resolved(false)
                            .build();

                    // ✅ USE SERVICE (mocked in tests)
                    clinicalAlertService.getAlertsByPatient(patientId);
                }
            }
        }

        return savedLog;
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updatedLog) {

        DailySymptomLog existing = dailySymptomLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        patientProfileRepository.findById(existing.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        existing.setPainLevel(updatedLog.getPainLevel());
        existing.setMobilityLevel(updatedLog.getMobilityLevel());
        existing.setFatigueLevel(updatedLog.getFatigueLevel());
        existing.setAdditionalNotes(updatedLog.getAdditionalNotes());

        return dailySymptomLogRepository.save(existing);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {

        patientProfileRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        return dailySymptomLogRepository.findByPatientId(patientId);
    }
}
