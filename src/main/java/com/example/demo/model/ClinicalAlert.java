package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "clinical_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicalAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private PatientProfile patient;

    @Column(nullable = false)
    private LocalDate alertDate;

    @Column(nullable = false)
    private String severity; // LOW / MEDIUM / HIGH

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Boolean resolved;
}
