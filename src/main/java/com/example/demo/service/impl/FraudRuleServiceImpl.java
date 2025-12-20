package com.example.demo.service.impl;

import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {
    private final FraudRuleRepository fraudRuleRepository;

    // Strict constructor order: FraudRuleRepository [cite: 58, 438]
    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule addRule(FraudRule rule) {
        if (fraudRuleRepository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("Invalid or duplicate rule name"); // [cite: 277, 440]
        }
        
        String sev = rule.getSeverity();
        if (!"LOW".equals(sev) && !"MEDIUM".equals(sev) && !"HIGH".equals(sev)) {
            throw new IllegalArgumentException("Invalid severity"); // [cite: 279, 442]
        }
        
        return fraudRuleRepository.save(rule);
    }

    @Override
    public List<FraudRule> getAllRules() {
        return fraudRuleRepository.findAll(); // [cite: 169, 443]
    }
}