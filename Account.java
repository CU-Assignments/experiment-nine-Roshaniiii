package com.example;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    private int accountNumber;
    private String holderName;
    private double balance;

    // Getters and Setters
}
