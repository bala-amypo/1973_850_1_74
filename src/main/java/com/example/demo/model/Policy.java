package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policies") // Required table name
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key
    private Long id;

    // Many-to-one with User: Each policy has one owner
    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

    @Column(unique = true, nullable = false) // policyNumber must be unique
    private String policyNumber;

    private String policyType; // e.g., HEALTH, MOTOR

    private LocalDate startDate; // Policy start date

    private LocalDate endDate; // Policy end date

    // One-to-many with Claim: Inverse side; Claim.policy is owning
    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims = new ArrayList<>();

    // No-arg constructor
    public Policy() {
    }

    // Parameterized constructor
    public Policy(User user, String policyNumber, String policyType, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }
}`