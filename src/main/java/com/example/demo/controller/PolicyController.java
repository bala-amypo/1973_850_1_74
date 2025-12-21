package com.example.demo.controller;

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/policies") // [cite: 295]
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) { // [cite: 296]
        this.policyService = policyService;
    }

    @PostMapping("/{userId}") // [cite: 299]
    public ResponseEntity<Policy> createPolicy(@PathVariable Long userId, @RequestBody PolicyDto policyDto) {
        // Fix 1: Manually map DTO fields to the Entity object [cite: 139-143, 234]
        Policy policy = new Policy();
        policy.setPolicyNumber(policyDto.getPolicyNumber());
        policy.setPolicyType(policyDto.getPolicyType());
        policy.setStartDate(policyDto.getStartDate());
        policy.setEndDate(policyDto.getEndDate());
        
        return ResponseEntity.ok(policyService.createPolicy(userId, policy));
    }

    @GetMapping("/user/{userId}") // [cite: 300]
    public ResponseEntity<List<Policy>> getPoliciesByUser(@PathVariable Long userId) {
        // Fix 2: Use the updated method name 'getPoliciesByUser' [cite: 235]
        return ResponseEntity.ok(policyService.getPoliciesByUser(userId));
    }
}