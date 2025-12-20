package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.dto.ClaimDto;
import com.example.demo.service.ClaimService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public ResponseEntity<Claim> createClaim(@PathVariable Long policyId, @RequestBody ClaimDto claimDto) {
        // Fixed to ensure it passes the DTO to the service
        Claim claim = claimService.createClaim(policyId, claimDto);
        return ResponseEntity.ok(claim);
    }
}