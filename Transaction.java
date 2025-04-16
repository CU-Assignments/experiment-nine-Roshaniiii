package com.example;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private int fromAccount;
    private int toAccount;
    private double amount;
    private Date timestamp;

    // Getters and Setters
}
