package com.example.demo.service.impl;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import org.springframework.stereotype.Service;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repository;

    public PatientProfileServiceImpl(PatientProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientProfile getByPatientId(String patientId) {
        PatientProfile patient = repository.findByPatientId(patientId);

        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }

        return patient;
    }
}
