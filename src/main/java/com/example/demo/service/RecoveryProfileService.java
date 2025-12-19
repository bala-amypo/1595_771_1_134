package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveProfileService {

    List<RecoveryCurveProfile> getRecoveryCurveBySurgeryType(String surgeryType);
}
