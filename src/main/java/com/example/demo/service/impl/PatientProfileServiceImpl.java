package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PatientProfile;

public interface PatientProfileService {
    PatientProfile createPatient(PatientProfile patientProfile);
    List<PatientProfile> getPatientProfile();
     PatientProfile getById(long id);
}