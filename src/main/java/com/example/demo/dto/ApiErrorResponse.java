package com.example.demo.dto;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private String message;
    private LocalDateTime timestamp;

    public ApiErrorResponse(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
