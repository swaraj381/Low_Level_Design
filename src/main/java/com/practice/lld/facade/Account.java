package com.practice.lld.facade;

public class Account {
    public boolean verifyAccount(String accountNumber) {
        System.out.println("Account verified: " + accountNumber);
        return true;
    }
}