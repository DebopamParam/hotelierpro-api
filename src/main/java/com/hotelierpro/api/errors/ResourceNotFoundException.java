package com.hotelierpro.api.errors;

// This is our custom exception. It's an "unchecked" exception because it extends RuntimeException.
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
