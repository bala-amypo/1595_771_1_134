package com.example.demo.service.impl;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public DailySymptomLog logDailySymptoms(DailySymptomLog log) {
        log.setSubmittedAt(LocalDateTime.now());
        return repository.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsForPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
