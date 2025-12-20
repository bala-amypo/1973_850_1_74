package com.example.demo.service;

import com.example.demo.model.Claim;
import com.example.demo.dto.ClaimDto;

public interface ClaimService {
    // This fixes the "incompatible types" error by accepting ClaimDto
    Claim createClaim(Long policyId, ClaimDto claimDto);
}