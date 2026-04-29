package com.list.ecommerce.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String SECRET = "minhachavesupersecretapradarcertoeunaoaguentomaisaescola";

    public String gerarToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();

    }
    public static String pegarEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
