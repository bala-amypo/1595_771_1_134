package com.example.demo.repository;

import com.example.demo.model.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveProfileRepository {

    List<RecoveryCurveProfile> findBySurgeryTypeOrderByDayNumberAsc(String surgeryType);

    List<RecoveryCurveProfile> findAll();

    RecoveryCurveProfile save(RecoveryCurveProfile curve);
}
