package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Claim;
import com.example.demo.model.Policy;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {
    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    // Constructor Injection in exact order [cite: 425]
    public ClaimServiceImpl(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Claim createClaim(Long policyId, Claim claim) {
        Policy policy = policyRepository.findById(policyId)
            .orElseThrow(() -> new ResourceNotFoundException("Policy not found")); // [cite: 82, 252]

        if (claim.getClaimAmount() < 0) {
            throw new IllegalArgumentException("Invalid claim amount"); // [cite: 80, 253, 456]
        }
        if (claim.getClaimDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid claim date"); // [cite: 81, 254, 457]
        }

        claim.setPolicy(policy);
        claim.setStatus("PENDING"); // [cite: 71]
        return claimRepository.save(claim);
    }

    @Override
    public Claim getClaim(Long claimId) {
        return claimRepository.findById(claimId)
            .orElseThrow(() -> new ResourceNotFoundException("Claim not found")); // [cite: 83, 255]
    }

    @Override
    public List<Claim> getAllClaims() {
        return claimRepository.findAll(); // [cite: 248]
    }
}