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
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(@PathVariable Long patientId) {
        List<ClinicalAlertRecord> alerts = clinicalAlertService.getAlertsByPatient(patientId);
        return ResponseEntity.ok(alerts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalAlertRecord> getAlertById(@PathVariable Long id) {
        return clinicalAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(@PathVariable Long id) {
        ClinicalAlertRecord resolved = clinicalAlertService.resolveAlert(id);
        return ResponseEntity.ok(resolved);
    }
}
