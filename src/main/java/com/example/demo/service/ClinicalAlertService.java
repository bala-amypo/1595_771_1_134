package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;
import java.util.List;

public interface ClinicalAlertService {
    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);
    ClinicalAlertRecord getAlertById(Long alertId);
}
