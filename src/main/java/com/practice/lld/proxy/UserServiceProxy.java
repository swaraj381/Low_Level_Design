package com.practice.lld.proxy;

/*
Key Benefits of the Proxy Design Pattern

Access Control: Only the right users can perform sensitive actions.
Plug-and-Play*: Easily add logging, rate limiting, caching, etc., without touching the real service.
Follows Interface Segregation: Clients don't know whether they're calling the proxy or the actual service.
Code Separation: Keeps your business logic clean and testable.




========================================
PROXY DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What is Proxy Pattern?

Answer:
Proxy Pattern provides a surrogate object that controls access to
another object. It acts as an intermediary between client and real object.


Q2: Why do we use Proxy Pattern?

Answer:
To add additional logic like:
- Access control
- Logging
- Caching
- Rate limiting
without modifying the original class.


Q3: How does Proxy achieve loose coupling?

Answer:
Client interacts with the same interface (PaymentService),
and does not know whether it is calling proxy or real object.


Q4: What are the types of Proxy?

Answer:
- Virtual Proxy (lazy loading)
- Protection Proxy (access control)
- Caching Proxy
- Remote Proxy


Q5: Difference between Proxy and Decorator?

Answer:
Proxy controls access, while Decorator adds new functionality.


Q6: Where is Proxy used in real-world systems?

Answer:
- API gateways
- Security layers
- Hibernate lazy loading
- Caching systems


Q7: What are advantages of Proxy?

Answer:
- Adds control without modifying real object
- Improves security
- Keeps business logic clean
- Easy to extend


Q8: What are disadvantages?

Answer:
- Adds extra layer of abstraction
- Slight performance overhead
- Increases complexity


========================================
INTERVIEW SUMMARY
========================================

- Proxy controls access to real object.
- Used for security, caching, logging, etc.
- Client interacts with interface, not implementation.

*/

public class UserServiceProxy implements UserService {

    private final UserService realService;

    public UserServiceProxy(UserService realService) {
        this.realService = realService;
    }

    @Override
    public void getUser(User caller, User target) {
        realService.getUser(caller, target);
    }

    @Override
    public void deleteUser(User caller, User target) {
        if(caller.getRole().equals(Role.ADMIN) || caller.getName().equals(target.getName())){
            realService.deleteUser(caller, target);
        } else{
            System.out.println(caller.getName() + " is not authorized to delete user: " + target.getName());
        }
    }

}
