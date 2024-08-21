package com.example.DigitalLibrary.service;

public interface TransactionService {
    String issueBook(String book_name,long student_Id) throws Exception;
}
