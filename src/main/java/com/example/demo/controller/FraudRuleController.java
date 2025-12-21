package com.example.demo.controller;

import com.example.demo.dto.FraudRuleDto;
import com.example.demo.model.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules") // [cite: 310]
public class FraudRuleController {
    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping // 
    public ResponseEntity<FraudRule> addRule(@RequestBody FraudRuleDto ruleDto) {
        FraudRule rule = new FraudRule(
            ruleDto.getRuleName(),
            ruleDto.getConditionField(),
            ruleDto.getOperator(),
            ruleDto.getValue(),
            ruleDto.getSeverity()
        );
        return ResponseEntity.ok(fraudRuleService.addRule(rule));
    }

    @GetMapping // [cite: 315, 519]
    public ResponseEntity<List<FraudRule>> getAllRules() {
        return ResponseEntity.ok(fraudRuleService.getAllRules());
    }
}