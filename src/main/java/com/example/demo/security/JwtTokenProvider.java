// package com.example.demo.security;

// import com.example.demo.model.AppUser;
// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String JWT_SECRET = "secretKey";
//     private final long JWT_EXPIRATION = 3600000; // 1 hour

//     public String generateToken(AppUser user) {

//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                 .claim("role", user.getRole().name())
//                 .claim("id", user.getId())
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
//                 .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser()
//                     .setSigningKey(JWT_SECRET)
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException ex) {
//             return false;
//         }
//     }

//     public String getUsernameFromToken(String token) {
//         Claims claims = Jwts.parser()
//                 .setSigningKey(JWT_SECRET)
//                 .parseClaimsJws(token)
//                 .getBody();

//         return claims.getSubject();
//     }
// }
package com.example.demo.security;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String SECRET_KEY = "my-secret-key-12345"; // move to application.yml later
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public String generateToken(AppUser user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getEmailFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
