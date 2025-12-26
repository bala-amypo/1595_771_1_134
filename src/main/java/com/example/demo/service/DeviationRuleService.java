package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;
import java.util.Optional;

public interface DeviationRuleService {

    Optional<DeviationRule> getRuleByCode(String ruleCode);

    List<DeviationRule> getActiveRules();
}

