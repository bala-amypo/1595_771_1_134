package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recovery_curve_profiles")
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String surgeryType;

    @Column(nullable = false)
    private Integer dayNumber;

    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;

     public RecoveryCurveProfile() {
    }

     public RecoveryCurveProfile(Long id, String surgeryType, Integer dayNumber,
                                Integer expectedPainLevel,
                                Integer expectedMobilityLevel,
                                Integer expectedFatigueLevel) {
        this.id = id;
        this.surgeryType = surgeryType;
        this.dayNumber = dayNumber;
        this.expectedPainLevel = expectedPainLevel;
        this.expectedMobilityLevel = expectedMobilityLevel;
        this.expectedFatigueLevel = expectedFatigueLevel;
    }

    public RecoveryCurveProfile(Integer dayNumber, Integer expectedFatigueLevel, Integer expectedMobilityLevel, Integer expectedPainLevel, String surgeryType) {
        this.dayNumber = dayNumber;
        this.expectedFatigueLevel = expectedFatigueLevel;
        this.expectedMobilityLevel = expectedMobilityLevel;
        this.expectedPainLevel = expectedPainLevel;
        this.surgeryType = surgeryType;
    }

    public Long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public Integer getExpectedPainLevel() {
        return expectedPainLevel;
    }

    public Integer getExpectedMobilityLevel() {
        return expectedMobilityLevel;
    }

    public Integer getExpectedFatigueLevel() {
        return expectedFatigueLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setExpectedPainLevel(Integer expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }

    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) {
        this.expectedMobilityLevel = expectedMobilityLevel;
    }

    public void setExpectedFatigueLevel(Integer expectedFatigueLevel) {
        this.expectedFatigueLevel = expectedFatigueLevel;
    }
    
    
}
