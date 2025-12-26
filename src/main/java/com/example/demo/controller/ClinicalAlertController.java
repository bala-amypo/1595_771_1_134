package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService clinicalAlertService;

    public ClinicalAlertController(ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(@PathVariable Long patientId) {
        List<ClinicalAlertRecord> alerts = clinicalAlertService.getAlertsByPatient(patientId);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{alertId}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(@PathVariable Long alertId) {
        ClinicalAlertRecord alert = clinicalAlertService.getAlertById(alertId);
        return ResponseEntity.ok(alert);
    }

    @PostMapping("/{alertId}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(@PathVariable Long alertId) {
        ClinicalAlertRecord resolvedAlert = clinicalAlertService.markAsResolved(alertId);
        return ResponseEntity.ok(resolvedAlert);
    }
}
