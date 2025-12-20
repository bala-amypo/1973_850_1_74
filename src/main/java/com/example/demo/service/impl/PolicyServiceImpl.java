package com.example.demo.service.impl;

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.model.User;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PolicyService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository, UserRepository userRepository) {
        this.policyRepository = policyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Policy createPolicy(Long userId, PolicyDto policyDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Policy policy = new Policy();
        policy.setPolicyType(policyDto.getPolicyType());
        policy.setCoverageAmount(policyDto.getCoverageAmount());
        policy.setPremium(policyDto.getPremium());
        policy.setStartDate(policyDto.getStartDate());
        policy.setEndDate(policyDto.getEndDate());
        policy.setUser(user);
        
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getPoliciesByUserId(Long userId) {
        return policyRepository.findByUserId(userId);
    }
}