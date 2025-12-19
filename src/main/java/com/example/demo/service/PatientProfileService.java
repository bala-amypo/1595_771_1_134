package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {

    PatientProfile createPatient(PatientProfile patient);

    PatientProfile getPatientById(Long id);

    PatientProfile getPatientByPatientId(String patientId);

    List<PatientProfile> getAllPatients();
}
