package com.practice.lld.facade;

public class Funds {
    public boolean hasSufficientFunds(double amount) {
        System.out.println("Sufficient funds available");
        return true;
    }

    public void debit(double amount) {
        System.out.println("Debited: $" + amount);
    }
}
