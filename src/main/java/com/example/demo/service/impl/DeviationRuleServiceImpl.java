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

    private final DeviationRuleRepository ruleRepository;

    public DeviationRuleServiceImpl(DeviationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DeviationRule createRule(DeviationRule rule) {

        if (rule.getThreshold() == null || rule.getThreshold() <= 0) {
            throw new IllegalArgumentException("Threshold must be positive");
        }

        ruleRepository.findByRuleCode(rule.getRuleCode())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("Rule code already exists");
                });

        return ruleRepository.save(rule);
    }

    @Override
    public DeviationRule updateRule(Long id, DeviationRule updatedRule) {

        DeviationRule existing = ruleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Deviation rule not found")
                );

        //existing.setRuleCode(updatedRule.getRuleCode());
        //existing.setParameter(updatedRule.getParameter());
       // existing.setThreshold(updatedRule.getThreshold());
        //existing.setSeverity(updatedRule.getSeverity());
        //existing.setActive(updatedRule.getActive());

        return ruleRepository.save(existing);
    }

    @Override
    public List<DeviationRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public List<DeviationRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }

    @Override
    public Optional<DeviationRule> getRuleByCode(String ruleCode) {
        return ruleRepository.findByRuleCode(ruleCode);
    }
}
