package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;
import java.util.Optional;

public interface DeviationRuleService {

    // CREATE
    DeviationRule createRule(DeviationRule rule);

    // READ
    Optional<DeviationRule> getRuleByCode(String ruleCode);

    List<DeviationRule> getActiveRules();

    // UPDATE
    DeviationRule updateRule(Long id, DeviationRule rule);
}
