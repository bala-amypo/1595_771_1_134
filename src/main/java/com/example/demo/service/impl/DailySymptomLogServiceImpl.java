package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepository;
    private final PatientProfileRepository patientRepository;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertService clinicalAlertService;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository logRepository,
            PatientProfileRepository patientRepository,
            RecoveryCurveService recoveryCurveService,
            DeviationRuleService deviationRuleService,
            ClinicalAlertService clinicalAlertService
    ) {
        this.logRepository = logRepository;
        this.patientRepository = patientRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertService = clinicalAlertService;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        // 1️⃣ Validate patient exists
        PatientProfile patient = patientRepository.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        // 2️⃣ Prevent duplicate log per day
        logRepository.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Daily log already exists");
                });

        // 3️⃣ Prevent future date
        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future date not allowed");
        }

        // 4️⃣ Save log
        DailySymptomLog savedLog = logRepository.save(log);

        // 5️⃣ Trigger alerts (conceptual logic)
        long dayNumber = ChronoUnit.DAYS.between(
                patient.getCreatedAt().toLocalDate(),
                log.getLogDate()
        );

        List<RecoveryCurveProfile> curves =
                recoveryCurveService.getCurveForSurgery(patient.getSurgeryType());

        List<DeviationRule> rules = deviationRuleService.getActiveRules();

        for (DeviationRule rule : rules) {
            if ("PAIN".equals(rule.getParameter())
                    && log.getPainLevel() != null
                    && curves.size() > dayNumber
                    && log.getPainLevel() >
                    curves.get((int) dayNumber).getExpectedPainLevel() + rule.getThreshold()) {

                ClinicalAlertRecord alert = ClinicalAlertRecord.builder()
                        .patientId(log.getPatientId())
                        .logId(savedLog.getId())
                        .alertType("PAIN_SPIKE")
                        .severity(rule.getSeverity())
                        .message("Pain exceeds expected level")
                        .resolved(false)
                        .build();

                clinicalAlertService.createAlert(alert);
            }
        }

        return savedLog;
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {

        // Validate patient exists
        patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        return logRepository.findByPatientId(patientId);
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {

        DailySymptomLog existing = logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        // Preserve patientId
        updated.setPatientId(existing.getPatientId());
        updated.setId(existing.getId());

        return logRepository.save(updated);
    }
}
