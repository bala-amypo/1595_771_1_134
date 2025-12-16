package com.example.demo.model;
import java.time.LocalDateTime;

public class PatientProfile {
    private long id;
    private String patientId;
    private String fullName;
    private int age;
    private String surgeryType;
    private  boolean active;
    private LocalDateTime createdAt;

    public  PatientProfile(){
    }

    public PatientProfile(String patientId, String fullName, int age, String surgeryType, boolean active,
            LocalDateTime createdAt) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.surgeryType = surgeryType;
        this.active = active;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
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

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
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

