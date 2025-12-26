package com.example.demo.service;

import com.example.demo.model.DeviationRule;

import java.util.List;

public interface DeviationRuleService {

    DeviationRule getRuleByCode(String ruleCode);

    List<DeviationRule> getActiveRules();
}
