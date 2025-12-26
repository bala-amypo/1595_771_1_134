package com.example.demo.service.impl;

import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule getRuleByCode(String ruleCode) {
        DeviationRule rule = repository.findByRuleCode(ruleCode);

        if (rule == null) {
            throw new RuntimeException("Rule not found");
        }

        if (!rule.isActive()) {
            throw new RuntimeException("Rule is inactive");
        }

        return rule;
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
