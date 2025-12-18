package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {
    @Autowired
    PatientProfileRepository patientProfileRepository;

    @Override
    public PatientProfile createPatient(PatientProfile patientProfile) {
        return patientProfileRepository.save(patientProfile);
    }
     
    @Override
    public List<PatientProfile> getPatientProfile(){
        return patientProfileRepository.findAll();
    }

    @Override
    public PatientProfile getById(long id){
        Optional<PatientProfile> optionalProfile = patientProfileRepository.findById(id);
        return optionalProfile.orElse(null);
    }
}
