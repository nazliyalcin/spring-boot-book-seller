package com.shopping.shop.controller;

import com.shopping.shop.model.Book;
import com.shopping.shop.model.User;
import com.shopping.shop.service.IAuthenticationService;
import com.shopping.shop.service.IBookService;
import com.shopping.shop.service.IUserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {



    @Autowired
    private IBookService bookService;

    @PostMapping("save-book")
    public ResponseEntity<?> saveBook(@RequestBody Book book)
    {
        return new ResponseEntity<>(bookService.saveBook(book),HttpStatus.CREATED);
    }

    @GetMapping("get-book/{author}")
    public ResponseEntity<?> getBook(@PathVariable String author)
    {
        return new ResponseEntity<>(bookService.findBookByAuthor(author),HttpStatus.OK);
    }

    @DeleteMapping("delete-book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("get-allbooks")
    public ResponseEntity<?> getAllBooks()
    {
        return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);

    }

}
