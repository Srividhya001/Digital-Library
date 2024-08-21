package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.dtos.CreateBookRequest;
import com.example.DigitalLibrary.dtos.SearchBookRequest;
import com.example.DigitalLibrary.entites.Book;

import java.util.List;

public interface BookService {
     Book createBook(CreateBookRequest book);
   List<Book> searchBook(SearchBookRequest bookToSearch) throws Exception;
   Boolean isValidBookSearch(SearchBookRequest bookToSearch);
   // public String updateBookDetails(int bookId,createBookRequest book);
   // public String deleteBook(int bookId);

    Book assignBookToStudent(Book book);
}
