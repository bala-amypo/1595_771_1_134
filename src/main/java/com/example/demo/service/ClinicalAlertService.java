package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlertRecord createAlert(ClinicalAlertRecord alert);

    ClinicalAlertRecord resolveAlert(Long id);

    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);
}
