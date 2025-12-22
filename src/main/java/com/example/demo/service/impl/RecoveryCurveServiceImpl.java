package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveProfileRepository;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    private final RecoveryCurveProfileRepository recoveryCurveRepository;

    public RecoveryCurveServiceImpl(RecoveryCurveProfileRepository recoveryCurveRepository) {
        this.recoveryCurveRepository = recoveryCurveRepository;
    }

    @Override
    public RecoveryCurveProfile createCurveEntry(RecoveryCurveProfile curve) {
        return recoveryCurveRepository.save(curve);
    }

    @Override
    public List<RecoveryCurveProfile> getCurveForSurgery(String surgeryType) {
        return recoveryCurveRepository
                .findBySurgeryTypeOrderByDayNumberAsc(surgeryType);
    }

    @Override
    public List<RecoveryCurveProfile> getAllCurves() {
        return recoveryCurveRepository.findAll();
    }
}
