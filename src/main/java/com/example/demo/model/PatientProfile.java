package com.example.demo.model;

import java.time.LocalDateTime;


public class PatientProfile {
    private long id;
    private String patientID;
    private String fullName;
    private int age;
    private String email;
    private String surgeryType;
    private boolean active;
    private LocalDateTime createdAt;

    public PatientProfile(){
    }

    public PatientProfile(String patientID, String fullName, int age, String email, String surgeryType, boolean active,
            LocalDateTime createdAt) {
        this.patientID = patientID;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.surgeryType = surgeryType;
        this.active = active;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }





}
    