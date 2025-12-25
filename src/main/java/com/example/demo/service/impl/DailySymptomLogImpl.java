package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepository;
    private final PatientProfileRepository patientRepository;

    public DailySymptomLogServiceImpl(
            DailySymptomLogRepository logRepository,
            PatientProfileRepository patientRepository
    ) {
        this.logRepository = logRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {

        // patient must exist
        patientRepository.findById(log.getPatientId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        // future date validation
        if (log.getLogDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("future date not allowed");
        }

        // duplicate check
        logRepository.findByPatientIdAndLogDate(
                log.getPatientId(),
                log.getLogDate()
        ).ifPresent(existing -> {
            throw new IllegalArgumentException("Duplicate daily log");
        });

        return logRepository.save(log);
    }

    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog updated) {

        DailySymptomLog existing = logRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Daily log not found"));

        existing.setPainLevel(updated.getPainLevel());
        existing.setMobilityLevel(updated.getMobilityLevel());
        existing.setFatigueLevel(updated.getFatigueLevel());
        existing.setAdditionalNotes(updated.getAdditionalNotes());

        return logRepository.save(existing);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {

        patientRepository.findById(patientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Patient not found"));

        return logRepository.findByPatientId(patientId);
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Daily log not found"));
    }
}
