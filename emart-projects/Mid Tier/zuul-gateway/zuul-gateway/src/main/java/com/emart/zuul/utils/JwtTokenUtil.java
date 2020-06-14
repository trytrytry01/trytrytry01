package com.emart.zuul.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT utils
 */
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_USERID = "userId";

    /**
     * exporation time: 30 minutes
     */
    private static final long EXPIRATION_TIME = 1800000;
    /**
     * JWT SECRET
     */
    private static final String SECRET = "secret_fullstack";

    /**
     * issue JWT
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put( CLAIM_KEY_USERNAME, userDetails.getUsername() );
        claims.put( CLAIM_KEY_USERID, userDetails );
        return Jwts.builder()
                .setClaims( claims )
                .setExpiration( new Date( Instant.now().toEpochMilli() + EXPIRATION_TIME  ) )
                .signWith( SignatureAlgorithm.HS512, SECRET )
                .compact();
    }

    /**
     * check the token Expiration
     */
    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationFromToken( token );
        return expiration.before(new Date());
    }

    /**
     * get username from token
     */
    public String getUsernameFromToken(String token) {
        String username = getClaimsFromToken( token ).getSubject();
        return username;
    }

    /**
     * get the Expiration time of token
     */
    public Date getExpirationFromToken(String token) {
        Date expiration = getClaimsFromToken( token ).getExpiration();
        return expiration;
    }

    /**
     * decode the JWT
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey( SECRET )
                .parseClaimsJws( token )
                .getBody();
        return claims;
    }



}