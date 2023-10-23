package com.shopping.shop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userId",nullable = false,length = 100)
    private Long userId;

    @Column(name="bookId",nullable = false,length = 100)
    private Long bookId;


    @Column(name="purchaseTime",nullable = false)
    private LocalDateTime purchaseTime;

    @Column(name="price",nullable = false)
    private Double price;
}
