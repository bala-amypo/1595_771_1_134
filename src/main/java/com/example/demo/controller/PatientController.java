package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientProfileService patientProfileService;

    public PatientController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @PostMapping
    public ResponseEntity<PatientProfile> createPatient(@RequestBody PatientProfile patient) {
        PatientProfile result = patientProfileService.createPatient(patient);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientProfile> getPatientById(@PathVariable Long id) {
        PatientProfile patient = patientProfileService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<PatientProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        PatientProfile updated = patientProfileService.updatePatientStatus(id, active);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        List<PatientProfile> patients = patientProfileService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
}
