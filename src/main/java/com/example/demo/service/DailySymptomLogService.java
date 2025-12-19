package com.example.demo.service;

import com.example.demo.model.DailySymptomLog;

import java.util.List;

public interface DailySymptomLogService {

    DailySymptomLog logDailySymptoms(DailySymptomLog log);

    List<DailySymptomLog> getLogsForPatient(Long patientId);
}
