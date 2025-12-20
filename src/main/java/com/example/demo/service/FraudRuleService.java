package com.example.demo.service;

import com.example.demo.model.FraudRule;
import java.util.List;

public interface FraudRuleService {
    FraudRule addRule(FraudRule rule); // [cite: 435]
    List<FraudRule> getAllRules(); // [cite: 436]
}