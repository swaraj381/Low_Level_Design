package com.practice.lld.strategy;

import java.util.Scanner;

/*
Key Benefits of the Strategy Design Pattern
Before watching, make sure you give it a try
Easy to switch behavior: You can change what a class does without changing the class itself. Just switch strategies.
Single Responsibility Principle: The Strategy Pattern adheres to this principle
by allowing you to encapsulate algorithms or behaviors in separate classes, making your code more modular.
Open/Closed Principle: You can add new strategies without touching the old ones. This keeps your code stable.
No big if-else chains: Instead of writing big if-else or switch-case blocks, you just use the right strategy class.
Reusable logic: Once a strategy is written, you can reuse it in other parts of your program or other programs easily.



========================================
STRATEGY DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What problem does the Strategy Pattern solve?

Answer:
Strategy Pattern allows selecting an algorithm or behavior at runtime.
Instead of using multiple if-else or switch statements, it encapsulates
each behavior into separate classes and makes them interchangeable.


Q2: Where is Strategy used in this implementation?

Answer:
PaymentStrategy is the strategy interface, and concrete classes like
CreditCardPayment, PayPalPayment, and GooglePayPayment implement it.
The behavior (payment method) is selected at runtime.


Q3: How does this design achieve loose coupling?

Answer:
The client (Main or PaymentProcessor) depends only on the PaymentStrategy
interface, not on concrete implementations. This allows adding new payment
methods without modifying existing client code.


Q4: How is runtime behavior achieved?

Answer:
The strategy object is selected dynamically based on user input and passed
to PaymentProcessor, which uses it to execute the payment.


Q5: What is the role of PaymentProcessor?

Answer:
PaymentProcessor acts as a context class. It holds a reference to
PaymentStrategy and delegates the payment execution to it.


Q6: What are the advantages of Strategy Pattern?

Answer:
- Removes conditional logic (if-else / switch)
- Supports Open-Closed Principle
- Easy to add new behaviors
- Promotes clean and maintainable code


Q7: What are the disadvantages of Strategy Pattern?

Answer:
- Increases number of classes
- Client must know which strategy to use
- Can add slight complexity for simple use-cases


Q8: Can Strategy Pattern be combined with Factory Pattern?

Answer:
Yes. Factory Pattern can be used to create strategy objects, removing
object creation logic from the client. This makes the design cleaner
and more scalable.


Q9: Why use Factory along with Strategy?

Answer:
Strategy defines behavior, while Factory handles object creation.
Combining both removes conditional logic from the client and centralizes
object creation, improving maintainability.


Q10: Is this implementation fully following Open-Closed Principle (OCP)?

Answer:
Partially. Strategy Pattern follows OCP for behavior, but if the factory
uses switch-case, it still violates OCP. This can be improved using a
Map-based or registration-based factory.


Q11: How can you improve this design further?

Answer:
- Replace switch-case in factory with Map-based registry
- Use enums instead of raw input
- Add validation for user input
- Use dependency injection in real applications


Q12: What happens if no strategy is provided?

Answer:
If strategy is null, it can cause NullPointerException.
We should validate and throw a meaningful exception.


Q13: Real-world examples of Strategy Pattern?

Answer:
- Payment systems (UPI, Card, Wallet)
- Sorting algorithms (different strategies)
- Compression (zip, rar)
- Authentication (OAuth, JWT, SSO)


========================================
FACTORY + STRATEGY COMBINED - Q&A
========================================

Q14: How do Factory and Strategy work together?

Answer:
Factory is responsible for creating the appropriate Strategy object,
and Strategy defines the behavior. The client simply requests a strategy
from the factory and executes it.


Q15: What is the main benefit of combining them?

Answer:
- Removes object creation logic from client
- Removes conditional logic
- Fully modular and extensible design


Q16: What is the best improvement for this combined design?

Answer:
Use Map-based factory:
Map<PaymentType, Function<Scanner, PaymentStrategy>>
This removes switch-case and fully follows Open-Closed Principle.


========================================
INTERVIEW SUMMARY
========================================

- Strategy Pattern defines interchangeable behaviors.
- Factory Pattern handles object creation.
- Together they remove both behavior and creation complexity from client.
- Best implementation uses Map-based factory + enum for type safety.


*/
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Choose payment method:");
        System.out.println("1. CREDIT_CARD");
        System.out.println("2. PAYPAL");
        System.out.println("3. GOOGLE_PAY");

        int choice = scanner.nextInt();
        scanner.nextLine();

        PaymentType type = switch (choice) {
            case 1 -> PaymentType.CREDIT_CARD;
            case 2 -> PaymentType.PAYPAL;
            case 3 -> PaymentType.GOOGLE_PAY;
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        //  Factory used here
        PaymentStrategy strategy =
                PaymentStrategyFactory.getStrategy(type, scanner);

        PaymentProcessor processor = new PaymentProcessor(strategy);
        processor.processPayment(amount);

        scanner.close();
    }
}
