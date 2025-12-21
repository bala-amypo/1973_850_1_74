package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 46]

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // [cite: 47]

    @Column(unique = true)
    private String policyNumber; // [cite: 48]

    private String policyType; // [cite: 49]
    private LocalDate startDate; // [cite: 50]
    private LocalDate endDate; // [cite: 51]

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims; // [cite: 57]

    // No-arg constructor [cite: 53]
    public Policy() {}

    // Parameterized constructor - MUST match this signature [cite: 54]
    public Policy(User user, String policyNumber, String policyType, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Standard Getters and Setters [cite: 45]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public List<Claim> getClaims() { return claims; }
    public void setClaims(List<Claim> claims) { this.claims = claims; }
}