package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query("Select a from Author a where a.email=?")
     Author findByEmail(String email);
}
