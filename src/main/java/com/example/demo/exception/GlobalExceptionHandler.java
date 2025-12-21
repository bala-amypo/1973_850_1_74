package com.example.demo.exception;

import com.example.demo.dto.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // This tells Spring to handle exceptions globally [cite: 389]
public class GlobalExceptionHandler {

    // Handles cases where a record is missing [cite: 391]
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        // Message must contain "not found" [cite: 63, 378]
        ApiErrorResponse error = new ApiErrorResponse(ex.getMessage(), "Not Found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handles validation errors like negative amounts or wrong dates [cite: 392]
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        // Message must contain "Invalid" [cite: 64, 387]
        ApiErrorResponse error = new ApiErrorResponse(ex.getMessage(), "Invalid Input");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}



kill -9 $(lsof -t -i:9001)