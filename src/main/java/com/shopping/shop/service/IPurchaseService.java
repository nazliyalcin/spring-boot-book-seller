package com.shopping.shop.service;

import com.shopping.shop.model.Purchase;
import com.shopping.shop.repository.projection.IPurchaseItem;

import java.util.List;

public interface IPurchaseService {
    List<IPurchaseItem> findAllPurchasesOfUser(Long userId);

    Purchase savePurchase(Purchase p);
}
