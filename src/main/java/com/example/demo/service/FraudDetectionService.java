package com.example.demo.service;

import com.example.demo.model.FraudCheckResult;

public interface FraudDetectionService {
    FraudCheckResult evaluateClaim(Long claimId); // [cite: 446]
    FraudCheckResult getResultByClaim(Long claimId); // [cite: 447]
}