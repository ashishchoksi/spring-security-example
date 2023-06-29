package com.example.spring.security.controller;

import com.example.spring.security.dao.UserDao;
import com.example.spring.security.dto.AuthRequest;
import com.example.spring.security.filter.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    // private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody AuthRequest authRequest) {
        // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        UserDetails user = userDao.findUserByEmail(authRequest.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(404).body("Unable to fetch user!");
    }

}
