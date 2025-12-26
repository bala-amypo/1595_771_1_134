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

    // ✅ Get all alerts for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(
            @PathVariable Long patientId) {

        List<ClinicalAlertRecord> alerts =
                clinicalAlertService.getAlertsByPatient(patientId);

        return ResponseEntity.ok(alerts);
    }

    // ✅ Get alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(
            @PathVariable Long id) {

        ClinicalAlertRecord alert =
                clinicalAlertService.getAlertById(id);

        return ResponseEntity.ok(alert);
    }

    // ✅ Mark alert as resolved
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(
            @PathVariable Long id) {

        ClinicalAlertRecord resolvedAlert =
                clinicalAlertService.resolveAlert(id);

        return ResponseEntity.ok(resolvedAlert);
    }
}
