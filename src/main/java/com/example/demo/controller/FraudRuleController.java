package com.example.demo.controller;

// ADD THESE THREE LINES HERE
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;


@RestController
@RequestMapping("/api/rules")
public class FraudRuleController {
    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping
    public ResponseEntity<FraudRule> addRule(@RequestBody FraudRuleDto dto) {
        // Convert DTO to Model
        FraudRule rule = new FraudRule();
        rule.setRuleName(dto.getRuleName());
        rule.setConditionField(dto.getConditionField());
        rule.setOperator(dto.getOperator());
        rule.setValue(dto.getValue());
        rule.setSeverity(dto.getSeverity());
        
        return ResponseEntity.ok(fraudRuleService.addRule(rule));
    }
}