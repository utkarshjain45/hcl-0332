package com.hcld2.jwtdemo.service;

import com.hcld2.jwtdemo.dto.AuthRequest;
import com.hcld2.jwtdemo.dto.AuthResponse;
import com.hcld2.jwtdemo.entity.User;
import com.hcld2.jwtdemo.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest authRequest) {
        if (userRepository.findByUserName(authRequest.userName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of("error", "username is already present")
            );
        }

        userRepository.save(new User(authRequest.userName(), passwordEncoder.encode(authRequest.password())));
        return ResponseEntity.ok(
                Map.of("message", "user registered successfully")
        );
    }

    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest) {
        var user = userRepository.findByUserName(authRequest.userName()).orElse(null);
        if (user == null || !passwordEncoder.matches(authRequest.password(), user.getPassword())){
            ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error","username or password incorrect"));
        }
        return ResponseEntity.ok(
                new AuthResponse(user.getUserName(),
                        jwtService.generateToken(user.getUserName()))
        );
    }
}
