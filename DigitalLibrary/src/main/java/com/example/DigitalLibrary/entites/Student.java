package com.example.DigitalLibrary.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private String contact;
    @CreationTimestamp
    private Date created_On;
    @UpdateTimestamp
    private Date updated_On;
    private Date validity;

    @OneToMany( cascade = CascadeType.ALL,mappedBy= "student")
    //mappedby means refer to student variable in Book class
    private List<Book> bookList;

    //mappedBy means owner of the relationship
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
    private List<Transaction> transactionList;

    //add convenience methods for bi-directional relationship

    public  void addBooks(Book b){
        if(bookList == null){
            bookList=new ArrayList<>();


        }
        bookList.add(b);
        b.setStudent(this);
    }

    public void addTransaction(Transaction trans){
        if (transactionList ==null){
            transactionList=new ArrayList<>();
                   }
        transactionList.add(trans);
        trans.setStudent(this);

    }
}
