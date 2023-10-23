package com.shopping.shop.service;

import com.shopping.shop.model.Book;
import com.shopping.shop.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book saveBook(Book book)
    {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId)
    {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }


}
