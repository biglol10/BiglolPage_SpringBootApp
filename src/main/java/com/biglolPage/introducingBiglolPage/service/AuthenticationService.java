package com.biglolPage.introducingBiglolPage.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

// EXPIRATIONTIME defines the expiration time of the token in milliseconds, while SIGNINGKEY is an algorithm-specific signing key that's used to 
// digitally sign the JWT. You should use a base64-encoded string to do this. PREFIX defines the prefix of the token, and the Bearer schema is typically 
// used. The addToken method creates the token and adds it to the request's Authorization header. The signing key is encoded using the SHA-512 algorithm. 
// The method also adds Access-Control-Expose-Headers to the header with the Authorization value. This is needed because we are unable to access the 
// Authorization header through a JavaScript frontend by default. The getAuthentication method gets the token from the response Authorization header using 
// the parser() method provided by the jjwt library

public class AuthenticationService {
  static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
  static final String SIGNINGKEY = "SecretKey";
  static final String PREFIX = "Bearer";

  // Add token to Authorization header
  static public void addToken(HttpServletResponse res, String username) {
    String JwtToken = Jwts.builder().setSubject(username)
        .setExpiration(new Date(System.currentTimeMillis() 
            + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
        .compact();
    res.addHeader("Authorization", PREFIX + " " + JwtToken);
  res.addHeader("Access-Control-Expose-Headers", "Authorization");
  }

  // Get token from Authorization header
  static public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (token != null) {
      String user = Jwts.parser()
          .setSigningKey(SIGNINGKEY)
          .parseClaimsJws(token.replace(PREFIX, ""))
          .getBody()
          .getSubject();

      if (user != null) 
        return new UsernamePasswordAuthenticationToken(user, null,
            emptyList());
    }
    return null;
  }
}