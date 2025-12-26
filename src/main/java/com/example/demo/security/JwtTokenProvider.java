package com.example.demo.security;

import com.example.demo.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {
    private final Key key = Keys.hmacShaKeyFor("ReplaceThisWithASecureRandomSecretKeyOfEnoughLength123".getBytes());
    private final long validityInMs = 3600_000; // 1h

    public String generateToken(User user) {
        long now = System.currentTimeMillis();
        String roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("username", user.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + validityInMs))
                .signWith(key)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            return Long.valueOf(claims.getSubject());
        } catch (Exception e) {
            return null;
        }
    }

    public String getRolesFromToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            Object roles = claims.get("roles");
            return roles != null ? roles.toString() : "";
        } catch (Exception e) {
            return "";
        }
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
