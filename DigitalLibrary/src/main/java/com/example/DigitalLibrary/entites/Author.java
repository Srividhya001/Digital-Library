package com.example.DigitalLibrary.entites;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="author")
@Data
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int author_Id;
    private String name;
    @Column(unique=true,nullable=false)
    private String email;

    private String country;

    @CreationTimestamp
    private Date addedOn;

    @JsonBackReference
    @OneToMany(mappedBy = "author")
    //mappedby means refer to athor variable in Book
    private List<Book> bookList;


    public void addBooks(Book b){
        if(bookList ==null){
            bookList=new ArrayList<>();

        }
        bookList.add(b);
        b.setAuthor(this);
    }



}
