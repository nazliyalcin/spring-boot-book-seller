package com.shopping.shop.repository;

import com.shopping.shop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends JpaRepository<Book,Long> {


    List<Book> findByAuthor(String author);
}
