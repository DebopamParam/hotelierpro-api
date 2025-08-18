package com.hotelierpro.api.errors;

import java.util.List;
import java.util.Map;

// This DTO will be the standard error format for our entire API.
public class ErrorResponse {
    private int status;
    private String message;
    // This will hold field-specific validation errors.
    private Map<String, List<String>> errors;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(int status, String message, Map<String, List<String>> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    // Getters and Setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Map<String, List<String>> getErrors() { return errors; }
    public void setErrors(Map<String, List<String>> errors) { this.errors = errors; }
}
