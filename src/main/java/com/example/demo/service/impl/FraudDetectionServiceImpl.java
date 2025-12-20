package com.example.demo.service.impl;

import com.example.demo.model.Claim;
import com.example.demo.model.FraudCheckResult;
import com.example.demo.model.FraudRule;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.repository.FraudCheckResultRepository;
import com.example.demo.service.FraudDetectionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {
    private final ClaimRepository claimRepository;
    private final FraudRuleRepository fraudRuleRepository;
    private final FraudCheckResultRepository resultRepository;

    // Strict constructor order: ClaimRepository, FraudRuleRepository, FraudCheckResultRepository [cite: 59, 60, 449]
    public FraudDetectionServiceImpl(ClaimRepository claimRepository, 
                                     FraudRuleRepository fraudRuleRepository, 
                                     FraudCheckResultRepository resultRepository) {
        this.claimRepository = claimRepository;
        this.fraudRuleRepository = fraudRuleRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public FraudCheckResult evaluateClaim(Long claimId) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found")); // [cite: 260, 451]

        List<FraudRule> rules = fraudRuleRepository.findAll(); // [cite: 130, 452]
        FraudCheckResult result = new FraudCheckResult();
        result.setClaim(claim);
        result.setIsFraudulent(false);
        result.setCheckedAt(LocalDateTime.now()); // [cite: 296, 456]

        for (FraudRule rule : rules) {
            // Logic to evaluate claimAmount (basic comparison for project scope) [cite: 131, 453]
            if ("claimAmount".equals(rule.getConditionField())) {
                Double threshold = Double.parseDouble(rule.getValue());
                if (">".equals(rule.getOperator()) && claim.getClaimAmount() > threshold) {
                    result.setIsFraudulent(true); // [cite: 175, 454]
                    result.setTriggeredRuleName(rule.getRuleName()); // [cite: 454]
                    result.setRejectionReason("Flagged by rule: " + rule.getRuleName()); // [cite: 454]
                    break;
                }
            }
        }
        return resultRepository.save(result); // [cite: 176, 456]
    }

    @Override
    public FraudCheckResult getResultByClaim(Long claimId) {
        return resultRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found")); // [cite: 297, 457]
    }
}