package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    @Autowired
    private PatientProfileRepository patientProfileRepository;

    @Override
    public PatientProfile createPatient(PatientProfile patientProfile) {

        if (patientProfileRepository.findByEmail(patientProfile.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        if (patientProfileRepository.findByPatientID(patientProfile.getPatientID()).isPresent()) {
            throw new RuntimeException("Patient ID already exists");
        }

        return patientProfileRepository.save(patientProfile);
    }

    @Override
    public List<PatientProfile> getPatientProfile() {
        return patientProfileRepository.findAll();
    }

    @Override
    public PatientProfile getById(long id) {
        return patientProfileRepository.findById(id).orElse(null);
    }
    @Override
    public PatientProfile getByPatientId(String patientId){
        return patientProfileRepository.findByPatientId(patientId).orElse(null);
    }
    @Override
    public PatientProfile updatePatientStatus(Long id, boolean active) {

    PatientProfile patientProfile = patientProfileRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Patient not found with id: " + id));

    patientProfile.setActive(active);

    return patientProfileRepository.save(patientProfile);
}

}
