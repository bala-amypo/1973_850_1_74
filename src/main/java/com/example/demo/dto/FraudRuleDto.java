package com.example.demo.dto;

public class FraudRuleDto {
    private Long id; // [cite: 333]
    private String ruleName; // [cite: 334]
    private String conditionField; // [cite: 335]
    private String operator; // [cite: 336]
    private String value; // [cite: 337]
    private String severity; // [cite: 338]

    // Getters and Setters
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