package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviationRule {

    private Long id;
    private String ruleCode;
    private String parameter;
    private Integer threshold;
    private String severity;

    @Builder.Default
    private Boolean active = true;
}
