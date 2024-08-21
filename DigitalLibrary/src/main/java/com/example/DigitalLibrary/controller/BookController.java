package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.dtos.CreateBookRequest;
import com.example.DigitalLibrary.dtos.SearchBookRequest;
import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.service.BookService;
import com.example.DigitalLibrary.service.serviceImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController  {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public Book createBook(@RequestBody CreateBookRequest createBookRequest){
        //while creating book an author is mapped to it.So need to insert author object too
       return  bookService.createBook(createBookRequest);

    }

    @GetMapping("/searchBook")
    public List<Book> searchBook(@RequestBody SearchBookRequest searchBookRequest) throws Exception{
        //check if search is valid
        if(bookService.isValidBookSearch(searchBookRequest)) {
            return bookService.searchBook(searchBookRequest);
        }
        else{
            throw new Exception("Invalid Search Key");
        }

    }
}
