package com.example.DigitalLibrary.entites;

import com.example.DigitalLibrary.entites.enums.Genre;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="book")
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @CreationTimestamp
    private Date created_On;

    @UpdateTimestamp
    private Date updated_On;

    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    private String name;

    private int pages;

    @ManyToOne
    @JoinColumn(name="author_Id")
    //this joincolumn means author_id is a coloumn in Book table
    //that refers to author table
    private Author author;

    @ManyToOne
    @JoinColumn(name="studentId")
    //studentId column in Book that maps to student table
    private Student student;

    @JsonManagedReference
    @OneToMany( cascade =CascadeType.ALL,mappedBy="book")
    List<Transaction> transactionList;

    //add convenience method for bi-directional relationships

    //we add convenience methods only for lists because setter itself sets the author

    public void addTransaction(Transaction trans){
        if( transactionList == null){
            transactionList = new ArrayList<>();
        }
        transactionList.add(trans);

        trans.setBook(this);
    }


}
