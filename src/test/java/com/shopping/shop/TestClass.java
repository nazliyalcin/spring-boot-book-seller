package com.shopping.shop;

import com.shopping.shop.controller.BookController;
import com.shopping.shop.model.Book;
import com.shopping.shop.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
public class TestClass {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception{
        LocalDateTime d = LocalDateTime.now();
        Book b = new Book(1L,"title","author","desc",d,25.5);

        List<Book> bList = new ArrayList<Book>();
        bList.add(b);

        Mockito.when(bookService.findAllBooks()).thenReturn(bList);
        RequestBuilder rb = MockMvcRequestBuilders.get("http://localhost:8080/api/book/get-book/author").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockmvc.perform(rb).andReturn();

        String expected = "{\"id\":\"1L\",\"title\":\"title\",\"description\":\"desc\",\"createTime\":\"d\",\"price\":\"25.5\"}";
        System.out.println("nazli---->"+mvcResult.getResponse().getContentType());
        JSONAssert.assertEquals(expected,mvcResult.getResponse().getContentAsString(),false);

    }
}
