package com.example.demo.service.impl;

import com.example.demo.model.Policy;
import com.example.demo.model.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;

    // Strict constructor order: PolicyRepository, then UserRepository [cite: 56, 415]
    public PolicyServiceImpl(PolicyRepository policyRepository, UserRepository userRepository) {
        this.policyRepository = policyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Policy createPolicy(Long userId, Policy policy) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found")); // [cite: 238, 417]
        
        if (policyRepository.existsByPolicyNumber(policy.getPolicyNumber())) {
            throw new IllegalArgumentException("Policy number already exists"); // [cite: 236, 418]
        }
        if (policy.getEndDate().isBefore(policy.getStartDate())) {
            throw new IllegalArgumentException("Invalid dates"); // [cite: 237, 419]
        }
        policy.setUser(user);
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUser(Long userId) {
        return policyRepository.findByUserId(userId); // [cite: 420]
    }

    @Override
    public Policy getPolicy(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found")); // [cite: 378]
    }
}