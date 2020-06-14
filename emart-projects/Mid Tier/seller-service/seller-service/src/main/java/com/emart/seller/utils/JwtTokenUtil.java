package com.emart.seller.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    private static final String CLAIM_KEY_USERID = "userId";

    /**
     * JWT SECRET
     */
    private static final String SECRET = "secret_fullstack";


    /**
     * get username from token
     */
    public String getUsernameFromToken(String token) {
        String username = getClaimsFromToken( token ).getSubject();
        return username;
    }
    
    /**
     * get userId from token
     */
    public Long getUserIdFromToken(String token) {
    	Long userId = Long.valueOf(String.valueOf(getClaimsFromToken( token ).get(CLAIM_KEY_USERID)));
        return userId;
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