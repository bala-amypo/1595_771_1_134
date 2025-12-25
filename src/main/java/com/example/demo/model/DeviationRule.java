package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "deviation_rules",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "ruleCode")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruleCode;

    @Column(nullable = false)
    private String parameter;   // PAIN, MOBILITY, FATIGUE

    @Column(nullable = false)
    private Integer threshold;

    private String severity;

    private Boolean active = true;
}
