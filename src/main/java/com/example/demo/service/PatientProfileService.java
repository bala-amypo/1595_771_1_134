package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {

    PatientProfile createPatient(PatientProfile profile);

    PatientProfile getPatientById(Long id);

    List<PatientProfile> getAllPatients();

    PatientProfile updatePatientStatus(Long id, boolean active);
}
