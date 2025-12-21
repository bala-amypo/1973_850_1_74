package com.example.demo.dto;

import java.time.LocalDate;

public class ClaimDto {
    private Long id; [cite: 147]
    private Long policyId; [cite: 148]
    private LocalDate claimDate; [cite: 149]
    private Double claimAmount; [cite: 150]
    private String description; [cite: 151]
    private String status; [cite: 152]

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPolicyId() { return policyId; }
    public void setPolicyId(Long policyId) { this.policyId = policyId; }
    public LocalDate getClaimDate() { return claimDate; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
    public Double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}