package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;

import java.util.List;
import java.util.Optional;

public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {
        return repository.save(rule);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule rule) {

        DeviationRule existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        existing.setRuleCode(rule.getRuleCode());
        existing.setParameter(rule.getParameter());
        existing.setThreshold(rule.getThreshold());
        existing.setSeverity(rule.getSeverity());
        existing.setActive(rule.getActive());

        return repository.save(existing);
    }

    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
