package com.example.DigitalLibrary.dtos;

import com.example.DigitalLibrary.entites.Author;
import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.entites.Student;
import com.example.DigitalLibrary.entites.Transaction;
import com.example.DigitalLibrary.entites.enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateBookRequest {
    //to convert BookRequest to bookEntity
    @NotNull
    @Enumerated(value= EnumType.STRING)
    private Genre genre;
    @NotBlank
    private String name;

    private int pages;

    @NotBlank
    private String authorName;
    private String authorCountry;
    private String authorEmail;

    //to convert BookRequest to bookEntity

    public Book to(){
        return Book.builder()
                .genre(genre)
                .name(name)
                .pages(pages)
                .author(Author.builder()
                        .name(authorName)
                        .email(authorEmail)
                        .country(authorCountry)
                        .build())
                .build();

    }


}
