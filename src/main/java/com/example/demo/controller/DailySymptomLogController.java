package com.example.demo.service.impl;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository logRepository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<DailySymptomLog> getLogsByPatientId(Long patientId) {
        List<DailySymptomLog> logs = logRepository.findByPatientId(patientId);

        if (logs.isEmpty()) {
            throw new RuntimeException("No symptom logs found");
        }

        return logs;
    }
}
