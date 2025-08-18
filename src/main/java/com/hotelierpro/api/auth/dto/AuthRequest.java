package com.hotelierpro.api.auth.dto;

import jakarta.validation.constraints.NotBlank;

// This DTO is for the login request.
public class AuthRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
