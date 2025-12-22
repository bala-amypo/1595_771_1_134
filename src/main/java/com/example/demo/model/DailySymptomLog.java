package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(
    name = "daily_symptom_logs",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"patientId", "logDate"})
    }
)
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private LocalDate logDate;

    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;

    private String additionalNotes;

     public DailySymptomLog() {
    }

     public DailySymptomLog(Long id, Long patientId, LocalDate logDate,
                           Integer painLevel,
                           Integer mobilityLevel,
                           Integer fatigueLevel,
                           String additionalNotes) {
        this.id = id;
        this.patientId = patientId;
        this.logDate = logDate;
        this.painLevel = painLevel;
        this.mobilityLevel = mobilityLevel;
        this.fatigueLevel = fatigueLevel;
        this.additionalNotes = additionalNotes;
    }

 
    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public Integer getPainLevel() {
        return painLevel;
    }

    public Integer getMobilityLevel() {
        return mobilityLevel;
    }

    public Integer getFatigueLevel() {
        return fatigueLevel;
    }

    
