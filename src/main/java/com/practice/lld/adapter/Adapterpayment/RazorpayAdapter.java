package com.practice.lld.adapter.Adapterpayment;

public class RazorpayAdapter implements PaymentProcessor {
    // private RazorpayClient client;

    private String phoneNumber;
    private static final double USD_TO_INR = 87.0;

    public RazorpayAdapter(String phoneNumber) {
        // this.client = new RazorpayClient("key_id", "key_secret");
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amountInUSD) {
        double amountInINR = amountInUSD * USD_TO_INR;
        int amountInPaise = (int) (amountInINR * 100);
        // client.createPayment(phoneNumber, amountInPaise);
        System.out.println("Razorpay: Paid " + amountInPaise / 100.0 + " Rs using phone number " + phoneNumber);
    }
}