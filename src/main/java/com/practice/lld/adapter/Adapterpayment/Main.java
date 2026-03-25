package com.practice.lld.adapter.Adapterpayment;

/*

When Should You Use the Adapter Pattern?
1. You want to work with third-party APIs, but they have different method names or data formats.
2. You're dealing with legacy code that you cannot change.
3. You want to offer your system a unified interface so it's easier to maintain and update in the future.


Key Points of the Adapter Design Pattern
Before watching, make sure you give it a try
Keeps Code Clean and Consistent: Instead of putting if-else checks
everywhere to handle different formats or APIs, you use adapters to bring everything under one clean and unified interface.
Works Well With Legacy Code: Sometimes, you can't (or shouldn't) change the old code. Maybe it's part of a third-party library or it's already working in production. Instead of rewriting the legacy code, you wrap it with an adapter that talks to your modern system.
Plug and Play Architecture: You can easily switch from one library/service to another. Want to replace Stripe with PayPal in the future? Just write a new adapter. No need to touch the rest of your app.
========================================
ADAPTER DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What problem does the Adapter Pattern solve?

Answer:
Adapter Pattern allows incompatible interfaces to work together.
It acts as a bridge between the client and a third-party API by converting
one interface into another expected by the client.


Q2: Where is Adapter used in this implementation?

Answer:
Classes like StripeAdapter and RazorpayAdapter act as adapters.
They convert third-party payment APIs into a common interface
(PaymentProcessor) used by the client.


Q3: Why do we need Adapter Pattern here?

Answer:
Different payment providers (Stripe, Razorpay, etc.) have different APIs.
Adapter Pattern standardizes them so the client interacts with a single
interface (pay method) without worrying about implementation details.


Q4: What is the role of PaymentProcessor?

Answer:
PaymentProcessor is the target interface that defines a common method (pay).
All adapters implement this interface to ensure uniform behavior.


Q5: What are the advantages of Adapter Pattern?

Answer:
- Allows integration with third-party libraries
- Promotes code reusability
- Provides a clean abstraction layer
- Decouples client from external APIs


Q6: What are the disadvantages of Adapter Pattern?

Answer:
- Adds extra layer of abstraction
- Increases number of classes
- Can make debugging slightly harder


Q7: Real-world examples of Adapter Pattern?

Answer:
- Payment gateways (Stripe, Razorpay, PayPal)
- Database drivers
- Media players supporting different formats
- Legacy system integration


========================================
ADAPTER + STRATEGY + FACTORY - Q&A
========================================

Q8: Which patterns are used in this design?

Answer:
- Adapter Pattern → to unify different payment APIs
- Strategy Pattern → to select payment method at runtime
- Factory Pattern → to create appropriate adapter objects


Q9: How does Strategy Pattern work here?

Answer:
Each adapter (StripeAdapter, RazorpayAdapter) acts as a strategy.
At runtime, the appropriate strategy is selected and executed.


Q10: How does Factory Pattern improve this design?

Answer:
Factory removes object creation logic from the client.
Instead of using switch-case, it uses a Map-based registry to
dynamically create objects, improving scalability and maintainability.


Q11: Is this design following Open-Closed Principle (OCP)?

Answer:
Yes. New payment methods can be added by registering them in the factory
without modifying existing code.


Q12: How can you add a new payment method?

Answer:
- Create a new adapter class implementing PaymentProcessor
- Register it in the factory using:
  PaymentProcessorFactory.register("newType", Supplier)


Q13: What happens if an invalid payment type is provided?

Answer:
Factory throws an IllegalArgumentException.
This prevents null pointer issues and ensures fail-fast behavior.


Q14: How can this design be improved further?

Answer:
- Use Function instead of Supplier for dynamic input
- Use enum instead of raw strings for type safety
- Add validation and logging
- Use dependency injection (Spring) in real-world systems


Q15: Can this design be used in real-world systems?

Answer:
Yes. This is a common design in payment gateways where multiple providers
are integrated under a unified interface.


========================================
INTERVIEW SUMMARY
========================================

- Adapter Pattern integrates incompatible interfaces.
- Strategy Pattern allows runtime behavior selection.
- Factory Pattern handles object creation.
- Map-based factory removes conditional logic and improves scalability.
- Combined, these patterns create a flexible, extensible system.

*/
public class Main {
    public static void main(String[] args) {

        String selectedMethod = "razorpay";

        // Factory used (no switch)
        PaymentProcessor processor =
                PaymentProcessorFactory.getProcessor(selectedMethod);

        processor.pay(50.0);
    }
}
