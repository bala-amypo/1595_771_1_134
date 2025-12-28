package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Security
@Tag(name = "Clinical Alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService alertService;

    public ClinicalAlertController(ClinicalAlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ClinicalAlertRecord createAlert(@RequestBody ClinicalAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public ClinicalAlertRecord resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlertRecord> getAlertsByPatient(@PathVariable Long patientId) {
        return alertService.getAlertsByPatient(patientId);
    }

    @GetMapping
    public List<ClinicalAlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
