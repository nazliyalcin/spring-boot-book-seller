package com.shopping.shop.controller;

import com.shopping.shop.model.User;
import com.shopping.shop.service.IAuthenticationService;
import com.shopping.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/authentication")
public class AuthController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user)
    {
        if(userService.findByUserName(user.getUserName()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user)
    {

        return new ResponseEntity<>(authenticationService.signInReturnJWT(user),HttpStatus.OK);
    }

    @GetMapping("deneme")
    public String deneme()
    {

        return "deneme";
    }

}
