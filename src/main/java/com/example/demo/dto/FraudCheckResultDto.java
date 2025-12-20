package com.example.demo.dto;

import java.time.LocalDateTime;

public class FraudCheckResultDto {
    private Long claimId; // [cite: 342]
    private Boolean isFraudulent; // [cite: 343]
    private String triggeredRuleName; // [cite: 344]
    private String rejectionReason; // [cite: 345]
    private LocalDateTime checkedAt; // [cite: 346]

    // Getters and Setters
    public Long getClaimId() { return claimId; }
    public void setClaimId(Long claimId) { this.claimId = claimId; }
    public Boolean getIsFraudulent() { return isFraudulent; }
    public void setIsFraudulent(Boolean isFraudulent) { this.isFraudulent = isFraudulent; }
    public String getTriggeredRuleName() { return triggeredRuleName; }
    public void setTriggeredRuleName(String triggeredRuleName) { this.triggeredRuleName = triggeredRuleName; }
    public String getRejectionReason() { return rejectionReason; }
    public void setRejectionReason(String rejectionReason) { this.rejectionReason = rejectionReason; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}