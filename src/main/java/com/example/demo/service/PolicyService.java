package com.example.demo.service;

import com.example.demo.model.Policy;
import com.example.demo.dto.PolicyDto;
import java.util.List;

public interface PolicyService {
    // This fixes the "incompatible types" error
    Policy createPolicy(Long userId, PolicyDto policyDto);

    // This fixes the "cannot find symbol" error
    List<Policy> getPoliciesByUserId(Long userId);
}