package com.example.demo.dto;

public class PolicyDto {
    private String policyType;
    private double coverageAmount;
    private double premium;
    private String startDate;
    private String endDate;

    // Getters and Setters
    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public double getCoverageAmount() { return coverageAmount; }
    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }

    public double getPremium() { return premium; }
    public void setPremium(double premium) { this.premium = premium; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
}