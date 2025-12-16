package com.example.demo.model;

import java.time.LocalDate;

public class ClinicalAlert {
    private long id;
    private PatientProfile patient;
    private LocalDate alerDate;
    private String severity;
    private String message;
    private boolean resolved;

    public ClinicalAlert(){

    }

    public ClinicalAlert(LocalDate alerDate, String message, PatientProfile patient, boolean resolved, String severity) {
        this.alerDate = alerDate;
        this.message = message;
        this.patient = patient;
        this.resolved = resolved;
        this.severity = severity;
    }

    public long getId() {
        return id;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public LocalDate getAlerDate() {
        return alerDate;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
    }

    public void setAlerDate(LocalDate alerDate) {
        this.alerDate = alerDate;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }
    
    


}
