package com.example.demo.controller;

import com.example.demo.model.FraudRule;
import com.example.demo.dto.FraudRuleDto;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping
    public ResponseEntity<FraudRule> addRule(@RequestBody FraudRuleDto ruleDto) {
        FraudRule rule = fraudRuleService.createRule(ruleDto);
        return ResponseEntity.ok(rule);
    }
}