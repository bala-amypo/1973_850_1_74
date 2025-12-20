package com.example.demo.service;

import com.example.demo.model.FraudRule;
import com.example.demo.dto.FraudRuleDto;

public interface FraudRuleService {
    // This fixes the "cannot find symbol" error for createRule
    FraudRule createRule(FraudRuleDto ruleDto);
}