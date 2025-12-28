package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
@Tag(name = "Deviation Rules")
public class DeviationRuleController {

    private final DeviationRuleService ruleService;

    public DeviationRuleController(DeviationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public DeviationRule createRule(@RequestBody DeviationRule rule) {
        return ruleService.createRule(rule);
    }

    @PutMapping("/{id}")
    public DeviationRule updateRule(
            @PathVariable Long id,
            @RequestBody DeviationRule rule) {
        return ruleService.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<DeviationRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping
    public List<DeviationRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
