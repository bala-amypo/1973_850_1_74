package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/claims") // or /api/policies, etc.
public class ClaimController { 
    // ... rest of your code
}
@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Policy> createPolicy(@PathVariable Long userId, @RequestBody PolicyDto dto) {
        // Convert DTO to Model
        Policy policy = new Policy();
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        
        return ResponseEntity.ok(policyService.createPolicy(userId, policy));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Policy>> getPoliciesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(policyService.getPoliciesByUser(userId));
    }
}