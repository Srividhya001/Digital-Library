package com.example.DigitalLibrary.dtos;

import com.example.DigitalLibrary.entites.Book;
import com.example.DigitalLibrary.entites.Student;
import com.example.DigitalLibrary.entites.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetStudentResponse {
    private String name;
    private String contact;

    private Date validity;


    private List<Book> bookList;

    private List<Transaction> transactionList;

    public GetStudentResponse to (Student studEntity){
        return GetStudentResponse.builder()
                .name(studEntity.getName())
                .contact(studEntity.getContact())
                .validity(studEntity.getValidity())
                .bookList(studEntity.getBookList())
                .transactionList(studEntity.getTransactionList())
                .build();
    }
}
