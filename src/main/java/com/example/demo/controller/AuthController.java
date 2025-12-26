// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//     private final UserService userService;
//     private final JwtTokenProvider tokenProvider;

//     public AuthController(UserService userService, JwtTokenProvider tokenProvider) {
//         this.userService = userService;
//         this.tokenProvider = tokenProvider;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
//         User u = new User();
//         u.setUsername(req.getUsername());
//         u.setEmail(req.getEmail());
//         u.setPassword(req.getPassword());
//         User saved = userService.registerUser(u, req.getRole());
//         return ResponseEntity.ok(saved);
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req) {
//         User user = userService.findByUsername(req.getUsernameOrEmail());
//         String token = tokenProvider.generateToken(user);
//         AuthResponse resp = new AuthResponse();
//         resp.setToken(token);
//         resp.setUsername(user.getUsername());
//         resp.setRoles(user.getRoles().stream().map(r -> r.getName()).collect(java.util.stream.Collectors.toSet()));
//         return ResponseEntity.ok(resp);
//     }
// }//
