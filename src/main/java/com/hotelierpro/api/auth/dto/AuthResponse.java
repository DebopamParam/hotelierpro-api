package com.hotelierpro.api.auth.dto;

// This DTO is for the login response, containing the JWT.
public class AuthResponse {

    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    // Getter and Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}