package com.shopping.shop.service;

import com.shopping.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String userName);
    void makeAdmin(String userName);
}
