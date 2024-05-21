package com.afautos.businessmanagement.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtils {
    
    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generation}")
    private String userGeneration;

    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);
        return null;
    }

}