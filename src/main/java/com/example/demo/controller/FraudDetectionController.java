package com.example.demo.controller;

import com.example.demo.model.FraudCheckResult;
import com.example.demo.service.FraudDetectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud-check")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    // Constructor injection for compliance
    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/evaluate/{claimId}")
    public ResponseEntity<FraudCheckResult> evaluateClaim(@PathVariable Long claimId) {
        // This triggers the logic that loops through FraudRules
        return ResponseEntity.ok(fraudDetectionService.evaluateClaim(claimId));
    }

    @GetMapping("/result/{claimId}")
    public ResponseEntity<FraudCheckResult> getResult(@PathVariable Long claimId) {
        return ResponseEntity.ok(fraudDetectionService.getResultByClaim(claimId));
    }
}