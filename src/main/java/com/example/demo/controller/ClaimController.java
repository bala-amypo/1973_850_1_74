package com.example.demo.controller;

import com.example.demo.model.Claim;
import com.example.demo.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/{policyId}")
    public ResponseEntity<Claim> createClaim(@PathVariable Long policyId, @RequestBody Claim claim) {
        return ResponseEntity.ok(claimService.createClaim(policyId, claim));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaim(@PathVariable Long id) {
        return ResponseEntity.ok(claimService.getClaim(id));
    }
}