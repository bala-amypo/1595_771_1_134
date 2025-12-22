package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_alert_records")
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private Long logId;

    @Column(nullable = false)
    private String alertType;

    private String severity;

    private String message;

    @Column(nullable = false)
    private Boolean resolved = false;

     public ClinicalAlertRecord() {
    }

     public ClinicalAlertRecord(Long id, Long patientId, Long logId,
                               String alertType, String severity,
                               String message, Boolean resolved) {
        this.id = id;
        this.patientId = patientId;
        this.logId = logId;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
        this.resolved = resolved;
    }

    

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getLogId() {
        return logId;
    }

    public String getAlertType() {
        return alertType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
