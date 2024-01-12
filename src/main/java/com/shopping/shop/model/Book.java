package com.shopping.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title",nullable = false,length = 100)
    private String title;

    @Column(name="author",nullable = false,length = 100)
    private String author;

    @Column(name="description",nullable = false,length = 1000)
    private String description;

    @Column(name="createTime",nullable = false)
    private LocalDateTime createTime;

    @Column(name="price",nullable = false)
    private Double price;


}
