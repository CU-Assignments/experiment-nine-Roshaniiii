package com.example;

public class MainApp3 {
    public static void main(String[] args) {
        BankService bank = new BankService();

        try {
            bank.transferMoney(1001, 1002, 500.0);
            System.out.println("Transaction successful!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
