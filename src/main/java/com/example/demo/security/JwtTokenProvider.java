package com.example.demo.security;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(AppUser user) {
        // Simple dummy token for now (tests mock this)
        return "jwt-token-for-" + user.getEmail();
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token");
    }
}
