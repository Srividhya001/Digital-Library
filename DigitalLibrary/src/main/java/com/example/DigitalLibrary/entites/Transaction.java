package com.example.DigitalLibrary.entites;

import com.example.DigitalLibrary.entites.enums.TransactionStatus;
import com.example.DigitalLibrary.entites.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="transaction")
@Data
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_Id;
    private String externalTxnId;

    @CreationTimestamp
    private Date transactionDate;

    @UpdateTimestamp
    private Date updatedOn;

    private Double fineAmount;

    private TransactionStatus transactionStatus;
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name="bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;

}
