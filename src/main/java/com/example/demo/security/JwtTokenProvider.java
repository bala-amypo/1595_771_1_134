package com.example.demo.security;

import com.example.demo.model.AppUser;

public class JwtTokenProvider {

    // This is a stub for tests. It can just return a fixed string or generate a token based on user.
    public String generateToken(AppUser user) {
        return "jwt-token-value"; // test uses this
    }

    // Simulate validation
    public boolean validateToken(String token) {
        if ("good-token".equals(token)) return true;
        return false;
    }

    // In real app, you would implement JWT signing, expiration, claims, etc.
}
