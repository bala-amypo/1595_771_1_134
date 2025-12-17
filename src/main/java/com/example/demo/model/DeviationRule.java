package com.example.demo.model;

public class DeviationRule {
    private long id;
    private String surgeryType;
    private String symptomParameter;
    private int thresholdDeviation;
    private boolean active;

    public DeviationRule(){

    }

    public DeviationRule(boolean active, String surgeryType, String symptomParameter, int thresholdDeviation) {
        this.active = active;
        this.surgeryType = surgeryType;
        this.symptomParameter = symptomParameter;
        this.thresholdDeviation = thresholdDeviation;
    }

    public long getId() {
        return id;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public String getSymptomParameter() {
        return symptomParameter;
    }

    public int getThresholdDeviation() {
        return thresholdDeviation;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setSymptomParameter(String symptomParameter) {
        this.symptomParameter = symptomParameter;
    }

    public void setThresholdDeviation(int thresholdDeviation) {
        this.thresholdDeviation = thresholdDeviation;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    

    
}
