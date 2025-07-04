package com.crm.leadAngel.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET = "mySuperSecretKeyForJWTValidation123456789";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
            .signWith(SECRET_KEY)
            .compact();
    }

    public static String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public static boolean validateToken(String token, String expectedUsername) {
        String username = getUsernameFromToken(token);
        return username.equals(expectedUsername) && !isTokenExpired(token);
    }

    private static boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getExpiration();
        return expiration.before(new Date());
    }

    public static String validateToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
}
