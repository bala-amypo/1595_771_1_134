package com.example.demo.model;

public class RecoveryCurveProfile {
    private long id;
    private String surgeryType;
    private int dayNumber;
    private int expectedPainLevel;
    private int expectedMobilityLevel;
    private int expectedFatigueLevel;

    public RecoveryCurveProfile(){

    }

    public RecoveryCurveProfile(String surgeryType, int dayNumber, int expectedPainLevel, int expectedMobilityLevel,
            int expectedFatigueLevel) {
        this.surgeryType = surgeryType;
        this.dayNumber = dayNumber;
        this.expectedPainLevel = expectedPainLevel;
        this.expectedMobilityLevel = expectedMobilityLevel;
        this.expectedFatigueLevel = expectedFatigueLevel;
    }

    public long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getExpectedPainLevel() {
        return expectedPainLevel;
    }

    public int getExpectedMobilityLevel() {
        return expectedMobilityLevel;
    }

    public int getExpectedFatigueLevel() {
        return expectedFatigueLevel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public void setExpectedPainLevel(int expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }

    public void setExpectedMobilityLevel(int expectedMobilityLevel) {
        this.expectedMobilityLevel = expectedMobilityLevel;
    }

    public void setExpectedFatigueLevel(int expectedFatigueLevel) {
        this.expectedFatigueLevel = expectedFatigueLevel;
    }





}
