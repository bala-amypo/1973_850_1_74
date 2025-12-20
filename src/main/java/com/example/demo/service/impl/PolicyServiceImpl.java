package com.example.demo.service.impl;

import com.example.demo.dto.PolicyDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Policy;
import com.example.demo.model.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Policy createPolicy(Long userId, PolicyDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // Using the getter we just added to PolicyDto
        if (policyRepository.existsByPolicyNumber(dto.getPolicyNumber())) {
            throw new IllegalArgumentException("policy number already exists");
        }

        Policy policy = new Policy();
        policy.setUser(user);
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setPremium(dto.getPremium());

        // FIX: Explicitly parsing String to LocalDate
        policy.setStartDate(LocalDate.parse(dto.getStartDate()));
        policy.setEndDate(LocalDate.parse(dto.getEndDate()));

        // Logic check: endDate must be after startDate
        if (!policy.getEndDate().isAfter(policy.getStartDate())) {
            throw new IllegalArgumentException("invalid dates");
        }

        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));
    }

    // FIX: Implementing the missing method from PolicyService interface
    @Override
    public List<Policy> getPoliciesByUserId(Long userId) {
        return policyRepository.findByUserId(userId);
    }
}