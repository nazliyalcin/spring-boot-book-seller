package com.shopping.shop.service;

import com.shopping.shop.model.Purchase;
import com.shopping.shop.repository.IPurchaseRepository;
import com.shopping.shop.repository.projection.IPurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseService implements IPurchaseService{

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Override
    public List<IPurchaseItem> findAllPurchasesOfUser(Long userId){
        return purchaseRepository.findAllPurchasesOfUser(userId);
    }

    @Override
    public Purchase savePurchase(Purchase p){
        p.setPurchaseTime(LocalDateTime.now());
       return purchaseRepository.save(p);
    }

}
