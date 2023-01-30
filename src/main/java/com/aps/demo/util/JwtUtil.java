package com.aps.demo.util;

import com.aps.demo.config.JwtTokenFilter;
import com.aps.demo.entity.User;
import com.aps.demo.model.UserPrinciple;
import com.aps.demo.repository.UserRepository;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;
@Component
public class JwtUtil {
    public static long JWT_TOKEN_VALIDITY = (long) (60 * 60 * 1000);
    private static final String jwtSecret = "d5a99db8326bd1ca05e781a0dc9387715706cf5b09364f4a2e983a86216959ba";
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    @Autowired
    private UserRepository userRepository;

    public String generateJwtToken(long syskey, String username) {
        Optional<User> user = userRepository.findById(syskey);
        return Jwts.builder()
                .claim("syskey", syskey)
                .claim("username", username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public UserPrinciple validateJwtToken(String authToken) {
        UserPrinciple userPrinciple = new UserPrinciple();
        try {
            Jws<Claims> jwtClaims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            userPrinciple.setSyskey(jwtClaims.getBody().get("syskey",Long.class));
            userPrinciple.setUsername(jwtClaims.getBody().get("username", String.class));
        }  catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return userPrinciple;
    }
}
