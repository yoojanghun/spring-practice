package com.example.ecommerce.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationMs;

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .addClaims(claims)              // JWT payload(내용부분)에 key-value 데이터 추가
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(getkey())
                .compact();
    }

    private Key getkey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);        // String -> byte
        return Keys.hmacShaKeyFor(keyBytes);                        // byte -> Key(HMAC-SHA256)
    }
}
