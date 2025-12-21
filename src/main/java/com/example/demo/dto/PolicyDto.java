package com.example.demo.dto;

import java.time.LocalDate;

public class PolicyDto {
    private Long id; // [cite: 138]
    private Long userId; // [cite: 139]
    private String policyNumber; // [cite: 140]
    private String policyType; // [cite: 141]
    private LocalDate startDate; // [cite: 142]
    private LocalDate endDate; // [cite: 143]

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}