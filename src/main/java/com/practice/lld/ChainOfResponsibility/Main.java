package com.practice.lld.ChainOfResponsibility;

/*
========================================
CHAIN OF RESPONSIBILITY - INTERVIEW Q&A
========================================

Q1: What problem does Chain of Responsibility solve?

Answer:
It decouples the sender of a request from its receivers by allowing
multiple objects (handlers) to process the request in a chain.
Each handler decides whether to handle the request or pass it to the next.


Q2: Where is Chain of Responsibility used in this implementation?

Answer:
Each interview round (Technical, Bar Raiser, Behavioral) acts as a handler.
The candidate passes through each handler sequentially until rejected
or successfully cleared all rounds.


Q3: What is the role of InterviewHandler?

Answer:
It is the abstract base class that defines:
- Reference to the next handler
- Method to pass control (handle)
- Abstract method (hire) for processing logic


Q4: How does the chain work internally?

Answer:
Each handler:
1. Processes the request (candidate evaluation)
2. If successful → passes to next handler
3. If failed → stops the chain


Q5: How is loose coupling achieved?

Answer:
The client only interacts with the first handler.
It does not need to know how many handlers exist or their order.
Handlers are linked dynamically.


Q6: What are the advantages of Chain of Responsibility?

Answer:
- Decouples sender and receiver
- Flexible chain (can change order dynamically)
- Follows Single Responsibility Principle
- Easy to add/remove handlers


Q7: What are the disadvantages?

Answer:
- Request may go unhandled if chain is incomplete
- Debugging can be harder
- Can increase complexity


Q8: Is this design following Open-Closed Principle (OCP)?

Answer:
Yes. New handlers (e.g., ManagerRound) can be added without modifying
existing code. Just link them in the chain.


Q9: What happens if no handler processes the request?

Answer:
The request reaches the end of the chain without being handled.
We should handle this case explicitly (e.g., final rejection message).


Q10: How can we change the order of interviews?

Answer:
Simply change the chain linking:
technical.setNext(barRaiser);
barRaiser.setNext(behavioral);

Order is dynamic and configurable.


Q11: Can multiple handlers process the request?

Answer:
Yes. In this implementation, all handlers process sequentially
until one fails or chain ends.


Q12: Real-world examples of Chain of Responsibility?

Answer:
- Logging frameworks (INFO → DEBUG → ERROR)
- Authentication/Authorization filters
- Customer support escalation
- Middleware pipelines


Q13: Difference between Chain of Responsibility and Strategy?

Answer:
- Chain → request flows through multiple handlers
- Strategy → one algorithm is selected at runtime


Q14: Can Chain of Responsibility be combined with other patterns?

Answer:
Yes:
- Factory → to create handlers
- Builder → to build chain
- Decorator → to add behavior dynamically


Q15: How can this design be improved?

Answer:
- Avoid creating multiple Scanner objects
- Add logging and error handling
- Use configuration to define chain dynamically
- Make handlers stateless for scalability


========================================
INTERVIEW SUMMARY
========================================

- Chain of Responsibility passes request through multiple handlers.
- Each handler decides whether to process or forward.
- Promotes loose coupling and flexibility.
- Easily extensible by adding new handlers.
*/

public class Main {
    public static void main(String[] args) {

        String candidate = "Alice :";

        InterviewHandler technical = new TechnicalInterview();
        InterviewHandler barRaiser = new BarRaiserInterview();
        InterviewHandler behavioral = new BehavioralInterview();

        // 🔥 Chain creation
        technical.setNext(barRaiser);
        barRaiser.setNext(behavioral);

        // 🔥 Only ONE call
        technical.handle(candidate);
    }
}
