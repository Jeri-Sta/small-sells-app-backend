package br.com.app.smallsells.security.jwt;

import br.com.app.smallsells.user.service.UserDetailImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.MalformedInputException;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${project.jwtSecret}")
    private String jwtSecret;

    @Value("${project.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateTokenFromUserDetailsImpl(UserDetailImpl userDetail) {
        return Jwts.builder().setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        } catch(MalformedJwtException e) {
            System.out.println("Token inválido " + e.getMessage());
        } catch(ExpiredJwtException e) {
            System.out.println("Token expirado " + e.getMessage());
        } catch(UnsupportedJwtException e) {
            System.out.println("Token não suportado " + e.getMessage());
        } catch(IllegalArgumentException e) {
            System.out.println("Token Argumento inválido " + e.getMessage());
        }
        return false;
    }

    public String getUsernameToken(String token) {
        return Jwts.parser().setSigningKey(getSigninKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
}
