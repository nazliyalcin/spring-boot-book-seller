package com.shopping.shop.service;

import com.shopping.shop.model.User;
import com.shopping.shop.security.UserPrincipal;
import com.shopping.shop.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

  public User signInReturnJWT(User signInRequest){
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUserName(),signInRequest.getPassword()));

      UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
      String jwt = jwtProvider.generateToken(userPrincipal);

      User signInUser = userPrincipal.getUser();
      signInUser.setToken(jwt);

      return signInUser;

  }
}
