package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public ClinicalAlertRecord getAlertById(Long alertId) {
        return repository.findById(alertId)
                .orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long alertId) {
        ClinicalAlertRecord alert = getAlertById(alertId);
        alert.setResolved(true);
        return repository.save(alert);
    }
}
