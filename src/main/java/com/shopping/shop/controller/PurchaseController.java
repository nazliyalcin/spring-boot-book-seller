package com.shopping.shop.controller;

import com.shopping.shop.model.Purchase;
import com.shopping.shop.model.User;
import com.shopping.shop.security.UserPrincipal;
import com.shopping.shop.service.IAuthenticationService;
import com.shopping.shop.service.IPurchaseService;
import com.shopping.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {



    @Autowired
    private IPurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal)
    {
        return new ResponseEntity<>(purchaseService.findAllPurchasesOfUser(userPrincipal.getId()),HttpStatus.OK);
    }

}
