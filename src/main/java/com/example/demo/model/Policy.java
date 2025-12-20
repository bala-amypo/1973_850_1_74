package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "policies") // [cite: 44]
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Many-to-one with User [cite: 56]
    @JoinColumn(name = "user_id")
    private User user;

    @Column(unique = true) // Policy number must be unique [cite: 48, 59]
    private String policyNumber;

    private String policyType;
    private LocalDate startDate;
    private LocalDate endDate;

    public Policy() {} // [cite: 53]

    public Policy(User user, String policyNumber, String policyType, LocalDate startDate, LocalDate endDate) { // [cite: 54]
        this.user = user;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters [cite: 219]
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
}