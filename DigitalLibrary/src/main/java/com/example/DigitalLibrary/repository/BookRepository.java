package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.entites.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository <Book,Integer>{

    @Query("Select b from Book b where b.name like %?1")
    List<Book> findByName(String name);
    //enum is used here
    @Query("Select b from Book b where b.genre =?1")

    List<Book> findByGenre(Genre genre);

}
