package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientProfileController {

    private final PatientProfileRepository repository;

    @GetMapping
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<PatientProfile> addPatient(@RequestBody PatientProfile patient) {
        return ResponseEntity.ok(repository.save(patient));
    }
}
