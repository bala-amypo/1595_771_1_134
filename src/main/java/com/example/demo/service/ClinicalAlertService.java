package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlertRecord createAlert(ClinicalAlertRecord alert);

    List<ClinicalAlertRecord> getAllAlerts();

    ClinicalAlertRecord getAlertById(Long alertId);

    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);

    ClinicalAlertRecord resolveAlert(Long alertId);
}
