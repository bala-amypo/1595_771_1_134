package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository alertRepository;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return alertRepository.save(alert);
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long alertId) {

        ClinicalAlertRecord alert = alertRepository.findById(alertId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alert not found")
                );

        alert.setResolved(true);
        return alertRepository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {
        return alertRepository.findByPatientId(patientId);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return alertRepository.findAll();
    }

    @Override
    public Optional<ClinicalAlertRecord> getAlertById(Long id) {
        return alertRepository.findById(id);
    }
}
