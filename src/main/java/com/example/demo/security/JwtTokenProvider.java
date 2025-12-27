package com.example.demo.security;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(User user) {
        return "uid:" + user.getId()
                + ":uname:" + user.getUsername()
                + ":email:" + user.getEmail();
    }

    public Long getUserIdFromToken(String token) {
        // token parts: [0]=uid, [1]=<id>, [2]=uname, [3]=<username>, [4]=email, [5]=<email>
        String[] parts = token.split(":");
        if (parts.length < 2 || !"uid".equals(parts[0])) {
            throw new IllegalArgumentException("Invalid token");
        }
        return Long.parseLong(parts[1]);
    }

    public boolean validateToken(String token) {
        try {
            Long id = getUserIdFromToken(token);
            return id != null && id > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
