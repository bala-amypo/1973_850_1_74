package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository; // [cite: 426]
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (fraudRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Invalid or duplicate rule name"); // [cite: 100, 263]
        }

        String sev = rule.getSeverity();
        if (!("LOW".equals(sev) || "MEDIUM".equals(sev) || "HIGH".equals(sev))) {
            throw new IllegalArgumentException("Invalid severity"); // [cite: 101, 102, 265]
        }

        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll(); // [cite: 190, 266]
    }
}