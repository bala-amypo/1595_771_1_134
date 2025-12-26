package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {

    PatientProfile getByPatientId(String patientId);

    List<PatientProfile> getAllPatients();
}
