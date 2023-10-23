package com.shopping.shop.service;

import com.shopping.shop.model.Book;

import java.util.List;

public interface IBookService {
    Book saveBook(Book book);

    void deleteBook(Long bookId);

    List<Book> findAllBooks();

    List<Book> findBookByAuthor(String author);
}
