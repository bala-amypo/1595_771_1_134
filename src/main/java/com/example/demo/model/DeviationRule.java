package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "deviation_rules",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleCode")
    }
)
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false)
    private String parameter; // PAIN, MOBILITY, FATIGUE

    @Column(nullable = false)
    private Integer threshold;

    private String severity;

    @Column(nullable = false)
    private Boolean active = true;

     public DeviationRule() {
    }

     public DeviationRule(String ruleCode, String parameter, Integer threshold, String severity, Boolean active) {
        this.ruleCode = ruleCode;
        this.parameter = parameter;
        this.threshold = threshold;
        this.severity = severity;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public String getParameter() {
        return parameter;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public String getSeverity() {
        return severity;
    }

    public Boolean getActive() {
        return active;
    }
    





    



    
}