package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;
import java.util.Optional;

public interface ClinicalAlertService {

    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);

    Optional<ClinicalAlertRecord> getAlertById(Long alertId);

    ClinicalAlertRecord resolveAlert(Long alertId);

    List<ClinicalAlertRecord> getAllAlerts();
}
