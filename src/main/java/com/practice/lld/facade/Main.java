package com.practice.lld.facade;

/*
 Key Benefits of the Facade Design Pattern

Simplified Interface: The client only calls one method instead of handling many steps.
Easier to Maintain: If internal logic changes (e.g., how PIN is verified), you don't touch the client code.
Loose Coupling: The client is loosely connected to the system. That means better flexibility.
Cleaner Code: No more repeating steps across multiple places.
Scalability: In large systems, this pattern keeps the code manageable and easy to work with.


/*
========================================
FACADE DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What is Facade Pattern?

Answer:
Facade Pattern provides a simplified interface to a complex system,
allowing the client to interact with multiple subsystems through a single method.


Q2: What problem does it solve?

Answer:
It hides the complexity of multiple subsystems and provides a clean,
easy-to-use interface for the client.


Q3: How does it improve code design?

Answer:
- Reduces coupling between client and subsystems
- Improves readability
- Centralizes complex workflows
- Makes code easier to maintain


Q4: Where is Facade used in this example?

Answer:
PaymentFacade acts as a facade by coordinating validation,
bank processing, and notification in a single method.


Q5: What are the advantages of Facade?

Answer:
- Simplified interface
- Loose coupling
- Cleaner code
- Easier maintenance
- Better scalability


Q6: What are the disadvantages?

Answer:
- Can become a god class if too much logic is added
- May hide useful subsystem features


Q7: Difference between Facade and Proxy?

Answer:
Facade simplifies interaction, while Proxy controls access.


Q8: Difference between Facade and Adapter?

Answer:
Facade simplifies system usage, while Adapter converts one interface to another.


Q9: Real-world examples?

Answer:
- Payment processing systems
- Order processing systems
- Spring Boot service layer
- API gateways


Q10: When should you use Facade?

Answer:
- When system is complex
- When multiple steps are repeated
- When you want clean client interaction


========================================
INTERVIEW SUMMARY
========================================

- Facade simplifies complex systems.
- Provides single entry point.
- Improves maintainability and readability.



*/
public class Main {
    public static void main(String[] args) {
        BankFacade bank = new BankFacade();
        bank.withdraw("ACC123", "4321", 100.0);
    }
}
