package com.shopping.shop.service;


import com.shopping.shop.model.User;

public interface IAuthenticationService {
    User signInReturnJWT(User signInRequest);
}
