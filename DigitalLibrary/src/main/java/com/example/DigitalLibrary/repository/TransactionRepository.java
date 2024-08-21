package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
