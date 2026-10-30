package com.hcld2.jwtdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;
    private final long expireMs;

    public JwtService(@Value("${app.jwt.secret}") String secret,
                      @Value("${app.jwt.expiration-ms}") long expireMs) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.jwtVerifier = JWT.require(algorithm).build();
        this.expireMs = expireMs;
    }

    public String generateToken(String userName){
        Date date = new Date();
        return JWT.create()
                .withSubject(userName)
                .withIssuedAt(date)
                .withExpiresAt(new Date(date.getTime() + expireMs))
                .sign(algorithm);
    }

    public String verifyAndGetUserName(String token){
        try {
            return jwtVerifier.verify(token).getSubject();
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e);
        }
    }
}
