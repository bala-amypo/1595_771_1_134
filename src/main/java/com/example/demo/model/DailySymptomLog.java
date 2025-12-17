package com.example.demo.model;

import java.time.LocalDate;

public class DailySymptomLog {
    private long id;
    private PatientProfile patient;
    private LocalDate logDate;
    private int painlevel;
    private int mobilityLevel;
    private int fatigueLevel;
    private String notes;
    private LocalDateTime submittedAt;

    public DailySymptomLog(){

    }

    public DailySymptomLog(int fatigueLevel, LocalDate logDate, int mobilityLevel, String notes, int painlevel, PatientProfile patient, LocalDateTime submittedAt) {
        this.fatigueLevel = fatigueLevel;
        this.logDate = logDate;
        this.mobilityLevel = mobilityLevel;
        this.notes = notes;
        this.painlevel = painlevel;
        this.patient = patient;
        this.submittedAt = submittedAt;
    }

    public long getId() {
        return id;
    }

    public PatientProfile getPatient() {
        return patient;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public int getPainlevel() {
        return painlevel;
    }

    public int getMobilityLevel() {
        return mobilityLevel;
    }

    public int getFatigueLevel() {
        return fatigueLevel;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatient(PatientProfile patient) {
        this.patient = patient;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public void setPainlevel(int painlevel) {
        this.painlevel = painlevel;
    }

    public void setMobilityLevel(int mobilityLevel) {
        this.mobilityLevel = mobilityLevel;
    }

    public void setFatigueLevel(int fatigueLevel) {
        this.fatigueLevel = fatigueLevel;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
    
    

}
