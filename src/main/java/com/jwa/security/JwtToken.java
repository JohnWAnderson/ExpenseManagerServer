package com.jwa.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.jwa.exception.ApiError;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;

/**
 * @author John Anderson
 */
@Component
public class JwtToken {
    @Value("${app.jwtSecret}")
    private String jwtSecret;
    
    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    /**
     * @param authentication object of authentication
     * @return String of jwt generated token
     */
    public String generateToken(Authentication authentication) {
    	UserObject userPrincipal = (UserObject) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        return Jwts.builder().setSubject(Long.toString(userPrincipal.getId())).setIssuedAt(new Date()).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    /**
     * @param token to find user from
     * @return id of the user
     */
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
    
    /**
     * @param token the jwt token
     * @return boolean if successful
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            throw new ApiError("Invalid JWT signature");
        } catch (MalformedJwtException e) {
        	throw new ApiError("Invalid JWT token");
        } catch (ExpiredJwtException e) {
        	throw new ApiError("Expired JWT token");
        } catch (UnsupportedJwtException e) {
        	throw new ApiError("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
        	throw new ApiError("JWT claims string is empty.");
        } catch( Exception e) {
        	return false;	
        }
    }
}
