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

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(
            @PathVariable Long patientId) {

        return ResponseEntity.ok(
                clinicalAlertService.getAlertsByPatient(patientId)
        );
    }

    @GetMapping("/{alertId}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(
            @PathVariable Long alertId) {

        return clinicalAlertService.getAlertById(alertId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{alertId}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(
            @PathVariable Long alertId) {

        return ResponseEntity.ok(
                clinicalAlertService.resolveAlert(alertId)
        );
    }

    @GetMapping
    public ResponseEntity<List<ClinicalAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(
                clinicalAlertService.getAllAlerts()
        );
    }
}
