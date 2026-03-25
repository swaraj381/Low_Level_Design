package com.practice.lld.strategy;

public class GooglePayPayment implements PaymentStrategy{
    private String pin;

    public GooglePayPayment(String pin) {
        this.pin = pin;
    }

    @Override
    public void pay(double amount){
        System.out.println("Processing Google Pay payment of $" + amount);
    }
}
