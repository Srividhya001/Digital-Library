package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public String issueBook(@RequestParam("book_name") String book_name , @RequestParam("StudentId") int studentId) throws Exception{
        return transactionService.issueBook(book_name,studentId);
    }


}
