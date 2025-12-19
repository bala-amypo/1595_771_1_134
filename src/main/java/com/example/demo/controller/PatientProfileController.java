package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PatientProfile createPatient(@RequestBody PatientProfile patient) {
        return service.createPatient(patient);
    }

    @GetMapping("/{id}")
    public PatientProfile getPatientById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @GetMapping("/code/{patientId}")
    public PatientProfile getPatientByPatientId(@PathVariable String patientId) {
        return service.getPatientByPatientId(patientId);
    }

    @GetMapping
    public List<PatientProfile> getAllPatients() {
        return service.getAllPatients();
    }
}
