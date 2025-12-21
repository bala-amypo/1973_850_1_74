package com.example.demo.controller;

import com.example.demo.dto.ClaimDto;
import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims") // [cite: 302]
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}") // [cite: 306, 515]
    public ResponseEntity<Claim> createClaim(@PathVariable Long policyId, @RequestBody ClaimDto claimDto) {
        Claim claim = new Claim();
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimAmount(claimDto.getClaimAmount());
        claim.setDescription(claimDto.getDescription());
        return ResponseEntity.ok(claimService.createClaim(policyId, claim));
    }

    @GetMapping("/{id}") // [cite: 307, 516]
    public ResponseEntity<Claim> getClaim(@PathVariable Long id) {
        return ResponseEntity.ok(claimService.getClaim(id));
    }

    @GetMapping // [cite: 308]
    public ResponseEntity<List<Claim>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }
}












