package com.shopping.shop.controller;

import com.shopping.shop.model.User;
import com.shopping.shop.service.IAuthenticationService;
import com.shopping.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {


    @Autowired
    private IUserService userService;

    @PutMapping("/make-admin/{userName}")
    public ResponseEntity<?> makeAdmin(@PathVariable String userName)
    {
        userService.makeAdmin(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/make-admin/{userName}")
    public ResponseEntity<?> makeAdminPatch(@PathVariable String userName)
    {
        userService.makeAdmin(userName);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
