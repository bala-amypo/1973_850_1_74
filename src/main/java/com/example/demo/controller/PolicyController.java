package com.example.demo.controller;

import com.example.demo.model.Policy;
import com.example.demo.dto.PolicyDto;
import com.example.demo.service.PolicyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Policy> createPolicy(@PathVariable Long userId, @RequestBody PolicyDto policyDto) {
        Policy policy = policyService.createPolicy(userId, policyDto);
        return ResponseEntity.ok(policy);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Policy>> getPoliciesByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(policyService.getPoliciesByUserId(userId));
    }
}