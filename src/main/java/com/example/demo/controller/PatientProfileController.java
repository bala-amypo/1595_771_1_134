package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    private final PatientProfileService patientProfileService;

    public PatientProfileController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @PostMapping
    public ResponseEntity<PatientProfile> createPatient(
            @RequestBody PatientProfile patient) {

        return ResponseEntity.ok(
                patientProfileService.createPatient(patient)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getPatientById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                patientProfileService.getPatientById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(
                patientProfileService.getAllPatients()
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PatientProfile> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(
                patientProfileService.updatePatientStatus(id, active)
        );
    }

    @GetMapping("/lookup/{patientId}")
    public ResponseEntity<PatientProfile> getByPatientId(
            @PathVariable String patientId) {

        return patientProfileService.findByPatientId(patientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
