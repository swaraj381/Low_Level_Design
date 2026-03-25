package com.practice.lld.strategy;


import java.util.Scanner;

public class PaymentStrategyFactory {

    public static PaymentStrategy getStrategy(PaymentType type, Scanner scanner) {

        switch (type) {

            case PAYPAL:
                System.out.print("Enter your PayPal email: ");
                String email = scanner.nextLine();
                return new PayPalPayment(email);

            case GOOGLE_PAY:
                System.out.print("Enter your pin: ");
                String pin = scanner.nextLine();
                return new GooglePayPayment(pin);

            case CREDIT_CARD:
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your card number: ");
                String card = scanner.nextLine();
                System.out.print("Enter your CVV: ");
                String cvv = scanner.nextLine();
                System.out.print("Enter expiry (MM/YY): ");
                String expiry = scanner.nextLine();
                return new CreditCardPayment(name, card, cvv, expiry);

            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
