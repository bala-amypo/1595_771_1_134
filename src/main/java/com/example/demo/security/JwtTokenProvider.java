package com.example.demo.security;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(AppUser user) {
         return "jwt-token-for-" + user.getEmail();
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("jwt-token-for-");
    }

     public String getEmail(String token) {
        if (token == null) {
            return null;
        }

         return token.replace("jwt-token-for-", "");
    }
}
