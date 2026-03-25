package com.practice.lld.adapter.Adapterpayment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentProcessorFactory {

    private static final Map<String, Supplier<PaymentProcessor>> registry = new HashMap<>();

    // Static block for default registrations
    static {
        registry.put("stripe", () -> new StripeAdapter("4111-1111-1111-1111"));
        registry.put("razorpay", () -> new RazorpayAdapter("9876543210"));
    }

    public static PaymentProcessor getProcessor(String type) {

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Payment type cannot be null or empty");
        }

        Supplier<PaymentProcessor> supplier = registry.get(type.toLowerCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid payment method: " + type);
        }

        return supplier.get();
    }

    // Optional: dynamic registration
    public static void register(String type, Supplier<PaymentProcessor> supplier) {
        registry.put(type.toLowerCase(), supplier);
    }
}
