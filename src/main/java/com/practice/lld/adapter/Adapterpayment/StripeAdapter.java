package com.practice.lld.adapter.Adapterpayment;

public class StripeAdapter implements PaymentProcessor {
    // Real Stripe SDK uses static methods, no client object usually.
    // private StripeClient client;
    private String cardNumber;

    public StripeAdapter(String cardNumber) {
        //Stripe.apiKey = "sk_test_...";
        //no need to instantiate client
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        //stripe.makePayment(cardNumber,amountInUSD);
        System.out.println("Processing Stripe payment of $" + amountInUSD + " for card number " + cardNumber);
    }
}
