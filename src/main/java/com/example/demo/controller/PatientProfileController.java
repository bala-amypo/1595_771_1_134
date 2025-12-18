package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;

@RestController
@RequestMapping("/api/patients")
public class PatientProfileController {

    @Autowired
    PatientProfileService patientProfileService;

    @PostMapping
    public ResponseEntity<PatientProfile> create(
            @RequestBody PatientProfile patientProfile) {

        PatientProfile savedPatient =
                patientProfileService.createPatient(patientProfile);

        return ResponseEntity.status(201).body(savedPatient);
    }

    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAll() {
        return ResponseEntity.ok(patientProfileService.getPatientProfile());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getById(@PathVariable long id) {

        PatientProfile patient = patientProfileService.getById(id);

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/lookup/{patientId}")
    public ResponseEntity<PatientProfile> getByPatientId(
            @PathVariable String patientId) {

        PatientProfile patient =
                patientProfileService.getByPatientId(patientId);

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PatientProfile> updatePatientStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        PatientProfile updatedPatientProfile =
                patientProfileService.updatePatientStatus(id, active);

        return ResponseEntity.ok(updatedPatientProfile);
    }
}
