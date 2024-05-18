package br.com.app.smallsells.security.jwt;

import br.com.app.smallsells.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenService {

    private static final long expirationTime = 18000000;
    private String key = "String aleatoria";
    public String generateToken(User user){
        return  Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste")
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
