package com.example.demo.dto;

public class ClaimDto {
    private double claimAmount;
    private String incidentDate;
    private String description;

    // Getters and Setters
    public double getClaimAmount() { return claimAmount; }
    public void setClaimAmount(double claimAmount) { this.claimAmount = claimAmount; }

    public String getIncidentDate() { return incidentDate; }
    public void setIncidentDate(String incidentDate) { this.incidentDate = incidentDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}