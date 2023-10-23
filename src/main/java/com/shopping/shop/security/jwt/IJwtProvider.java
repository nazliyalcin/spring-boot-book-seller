package com.shopping.shop.security.jwt;

import com.shopping.shop.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IJwtProvider {
    Authentication getAuthentication(HttpServletRequest httpServletRequest);
   boolean validateToken(HttpServletRequest request);

    String generateToken(UserPrincipal auth);
}
