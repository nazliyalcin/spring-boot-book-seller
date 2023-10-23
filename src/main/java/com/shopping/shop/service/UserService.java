package com.shopping.shop.service;

import com.shopping.shop.model.Role;
import com.shopping.shop.model.User;
import com.shopping.shop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRole(Role.USER);
           user.setCreateTime(LocalDateTime.now());

           return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String userName)
    {
        return userRepository.findByUserName(userName);
    }

   @Transactional
    public void makeAdmin(String userName)
    {
        userRepository.updateUserRole(userName,Role.ADMIN);
    }
}
