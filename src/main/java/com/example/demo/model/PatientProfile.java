package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "patient_profiles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "patientId"),
        @UniqueConstraint(columnNames = "email")
    }
)
@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String patientId;

    @Column(nullable = false)
    private String fullName;

    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    private String surgeryType;

    @Builder.Default
    private Boolean active = true;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public PatientProfile(){

    }

    public PatientProfile(Integer age, String email, String fullName, String patientId, String surgeryType) {
        this.age = age;
        this.email = email;
        this.fullName = fullName;
        this.patientId = patientId;
        this.surgeryType = surgeryType;
    }

    public Long getId() {
        return id;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    

}
