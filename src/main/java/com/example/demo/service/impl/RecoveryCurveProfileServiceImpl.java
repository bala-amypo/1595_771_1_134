package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.service.RecoveryCurveProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveProfileServiceImpl implements RecoveryCurveProfileService {

    private final RecoveryCurveProfileRepository repository;

    public RecoveryCurveProfileServiceImpl(RecoveryCurveProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RecoveryCurveProfile> getRecoveryCurveBySurgeryType(String surgeryType) {
        return repository.findBySurgeryType(surgeryType);
    }
}
