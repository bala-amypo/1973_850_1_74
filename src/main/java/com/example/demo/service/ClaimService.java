package com.example.demo.service;

import com.example.demo.model.Claim;
import java.util.List;

public interface ClaimService {
    Claim createClaim(Long policyId, Claim claim); [cite: 246]
    Claim getClaim(Long claimId); [cite: 247]
    List<Claim> getAllClaims(); [cite: 248]
}