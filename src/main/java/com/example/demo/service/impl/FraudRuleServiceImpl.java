package com.example.demo.service.impl;

import com.example.demo.dto.FraudRuleDto;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;
import org.springframework.stereotype.Service;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleServiceImpl(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public FraudRule createRule(FraudRuleDto ruleDto) {
        FraudRule rule = new FraudRule();
        rule.setRuleName(ruleDto.getRuleName());
        rule.setRuleExpression(ruleDto.getRuleExpression());
        rule.setDescription(ruleDto.getDescription());
        rule.setActive(true);
        
        return fraudRuleRepository.save(rule);
    }
}