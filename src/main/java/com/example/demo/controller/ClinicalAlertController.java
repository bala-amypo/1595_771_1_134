package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService clinicalAlertService;

    public ClinicalAlertController(ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }

    // 🔹 Get all alerts for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(
            @PathVariable Long patientId) {

        List<ClinicalAlertRecord> alerts =
                clinicalAlertService.getAlertsByPatient(patientId);

        return ResponseEntity.ok(alerts);
    }

    // 🔹 Get alert by ID
    @GetMapping("/{alertId}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(
            @PathVariable Long alertId) {

        return clinicalAlertService.getAlertById(alertId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Resolve an alert
    @PutMapping("/{alertId}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(
            @PathVariable Long alertId) {

        ClinicalAlertRecord resolved =
                clinicalAlertService.resolveAlert(alertId);

        return ResponseEntity.ok(resolved);
    }

    // 🔹 Get all alerts (system-wide)
    @GetMapping
    public ResponseEntity<List<ClinicalAlertRecord>> getAllAlerts() {

        List<ClinicalAlertRecord> alerts =
                clinicalAlertService.getAllAlerts();

        return ResponseEntity.ok(alerts);
    }
}
