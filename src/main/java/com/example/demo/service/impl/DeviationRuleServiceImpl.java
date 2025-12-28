package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DeviationRule;
import com.example.demo.repository.DeviationRuleRepository;
import com.example.demo.service.DeviationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviationRuleServiceImpl implements DeviationRuleService {

    private final DeviationRuleRepository repository;

    public DeviationRuleServiceImpl(DeviationRuleRepository repository) {
        this.repository = repository;
    }

    // 🔹 CREATE RULE
    @Override
    public DeviationRule createRule(DeviationRule rule) {

        if (rule.getThreshold() == null || rule.getThreshold() <= 0) {
            throw new IllegalArgumentException("Threshold must be greater than zero");
        }

        return repository.save(rule);
    }

    // 🔹 GET RULE BY CODE
    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {
        return repository.findByRuleCode(ruleCode);
    }

    // 🔹 GET ACTIVE RULES
    @Override
    public List<DeviationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    // 🔹 UPDATE RULE
    @Override
    public DeviationRule updateRule(Long id, DeviationRule updatedRule) {

        DeviationRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));

        if (updatedRule.getThreshold() == null || updatedRule.getThreshold() <= 0) {
            throw new IllegalArgumentException("Threshold must be greater than zero");
        }

        existing.setRuleCode(updatedRule.getRuleCode());
        existing.setParameter(updatedRule.getParameter());
        existing.setThreshold(updatedRule.getThreshold());
        existing.setSeverity(updatedRule.getSeverity());

        // ✅ Prevent null overwrite
        if (updatedRule.getActive() != null) {
            existing.setActive(updatedRule.getActive());
        }

        return repository.save(existing);
    }
}
