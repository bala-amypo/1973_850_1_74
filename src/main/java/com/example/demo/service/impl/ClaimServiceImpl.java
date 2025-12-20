package com.example.demo.service.impl;

import com.example.demo.dto.ClaimDto;
import com.example.demo.model.Claim;
import com.example.demo.model.Policy;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.ClaimService;
import org.springframework.stereotype.Service;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final PolicyRepository policyRepository;

    public ClaimServiceImpl(ClaimRepository claimRepository, PolicyRepository policyRepository) {
        this.claimRepository = claimRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public Claim createClaim(Long policyId, ClaimDto claimDto) {
        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        Claim claim = new Claim();
        claim.setClaimAmount(claimDto.getClaimAmount());
        claim.setIncidentDate(claimDto.getIncidentDate());
        claim.setDescription(claimDto.getDescription());
        claim.setStatus("PENDING");
        claim.setPolicy(policy);

        return claimRepository.save(claim);
    }
}