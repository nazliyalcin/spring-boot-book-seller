package com.shopping.shop.repository;

import com.shopping.shop.model.Purchase;
import com.shopping.shop.repository.projection.IPurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("select b.title as title, ph.price as price, ph.purchaseTime as purchaseTime from Purchase ph left join Book b on b.id = ph.bookId where ph.userId = :userId")
    List<IPurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
