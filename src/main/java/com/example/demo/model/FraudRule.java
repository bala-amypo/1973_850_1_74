package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fraud_rules") // [cite: 86]
public class FraudRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // Rule name must be unique [cite: 100]
    private String ruleName;

    private String conditionField;
    private String operator; // >, <, =, etc. [cite: 91]
    private String value;
    private String severity; // LOW, MEDIUM, HIGH [cite: 93]

    public FraudRule() {} // [cite: 95]

    public FraudRule(String ruleName, String conditionField, String operator, String value, String severity) { // [cite: 96]
        this.ruleName = ruleName;
        this.conditionField = conditionField;
        this.operator = operator;
        this.value = value;
        this.severity = severity;
    }

    // Getters and Setters [cite: 219]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getConditionField() { return conditionField; }
    public void setConditionField(String conditionField) { this.conditionField = conditionField; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}