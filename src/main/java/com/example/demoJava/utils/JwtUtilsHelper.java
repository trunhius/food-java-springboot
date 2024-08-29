package com.example.demoJava.utils;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtilsHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String genernateToken(String data) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();

        return jws;
    }

    public Boolean verifyToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser()
                    .setSigningKey(key)
                    // .verifyWith(key) // or a constant key used to verify all signed JWTs
                    // .decryptWith(key) // or a constant key used to decrypt all encrypted JWTs
                    .build()
                    .parseSignedClaims(token);
            // Jwts.parser().setSigningKey(key).parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
