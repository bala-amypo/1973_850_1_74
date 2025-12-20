package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double claimAmount;
    private LocalDate claimDate;
    private String incidentDate; // Added for ClaimServiceImpl
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    @ManyToMany
    @JoinTable(name = "claim_suspected_rules")
    private Set<FraudRule> suspectedRules;

    @OneToOne(mappedBy = "claim")
    private FraudCheckResult fraudCheckResult;

    public Claim() {}
    public Claim(Policy policy, LocalDate claimDate, Double claimAmount, String description) {
        this.policy = policy;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.description = description;
    }

    // Setters to fix Errors
    public void setIncidentDate(String incidentDate) { this.incidentDate = incidentDate; }
    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }
    public void setStatus(String status) { this.status = status; }
    public void setPolicy(Policy policy) { this.policy = policy; }
    public Double getClaimAmount() { return claimAmount; }
    public LocalDate getClaimDate() { return claimDate; }
}