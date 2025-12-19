package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "daily_symptom_logs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"patient_id", "logDate"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private PatientProfile patient;

    @Column(nullable = false)
    private LocalDate logDate;

    @Column(nullable = false)
    private Integer painLevel;

    @Column(nullable = false)
    private Integer mobilityLevel;

    @Column(nullable = false)
    private Integer fatigueLevel;

    private String notes;

    @Column(nullable = false)
    private LocalDateTime submittedAt;
}
