package com.example.demo.security;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_MS = 86400000; // 1 day

    // ------------------------------------------------------------------
    // TOKEN GENERATION
    // ------------------------------------------------------------------
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .claim("roles",
                        user.getRoles()
                                .stream()
                                .map(Role::getName)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(key)
                .compact();
    }

    // ------------------------------------------------------------------
    // TOKEN VALIDATION
    // ------------------------------------------------------------------
    public boolean validateToken(String token) {
        try {
            getClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // ------------------------------------------------------------------
    // CLAIM EXTRACTION
    // ------------------------------------------------------------------
    public Long getUserIdFromToken(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    public String getUsernameFromToken(String token) {
        return getClaims(token).getSubject();
    }

    // ✅✅✅ THIS IS THE MISSING METHOD (FIX)
    public List<String> getRolesFromToken(String token) {
        Claims claims = getClaims(token);
        Object roles = claims.get("roles");

        if (roles instanceof List<?>) {
            return ((List<?>) roles)
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    // ------------------------------------------------------------------
    // INTERNAL
    // ------------------------------------------------------------------
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
