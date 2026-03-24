package com.practice.lld.builder.builderpattern;

/*
Now, we've created an immutable email object without writing multiple constructors or passing nulls.
Notice that we have used method chaining to create the object step by step which also results into clean code.

Key Benefits of Using the Builder Design Pattern
Before watching, make sure you give it a try
Immutability: Final class has no setters, so once created, it cannot be changed.
Cleaner Code: The Builder pattern allows method chaining, making the code cleaner and more readable.
No Constructor Overload: No more dozens of constructors for different use-cases.
Handles Optional Fields: You can set only what you need.


========================================
BUILDER DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What problem does the Builder Design Pattern solve?

Answer:
Builder Pattern solves the problem of creating complex objects with multiple
optional parameters. Instead of having multiple constructors or passing null values,
it allows step-by-step object creation in a readable and flexible way.


Q2: Why not use constructors for this?

Answer:
Using constructors leads to:
- Telescoping constructor problem (too many overloaded constructors)
- Poor readability
- Hard to manage optional fields

Builder Pattern avoids this by providing a clean and flexible way to construct objects.


Q3: How does Builder Pattern improve readability?

Answer:
Builder uses method chaining, allowing object creation in a step-by-step manner.
Example:
Email email = builder.setTo("a").setSubject("b").build();

This is much more readable than long constructors with multiple parameters.


Q4: How is immutability achieved in this design?

Answer:
The Email class is immutable because:
- All fields are private
- No setter methods are exposed
- Values are assigned only once via constructor
- Object is created only through the build() method

Once created, the object cannot be modified.


Q5: Why is EmailBuilder mutable but Email immutable?

Answer:
Builder is mutable because it is used to gradually construct the object.
Email is immutable to ensure thread safety, consistency, and predictability
after creation.


Q6: What is the role of build() method?

Answer:
The build() method validates required fields and constructs the final immutable object.
It acts as the final step in object creation and ensures object integrity.


Q7: How do you enforce mandatory fields?

Answer:
Mandatory fields are validated inside the build() method.
Example:
if (to == null) throw exception;

This ensures that required data is present before object creation.


Q8: What are optional fields in this example?

Answer:
Fields like cc, bcc, attachments are optional.
They are set only if needed using builder methods.


Q9: What is method chaining?

Answer:
Method chaining is returning the same object (this) from setter methods,
allowing multiple method calls in a single statement.


Q10: What are the advantages of Builder Pattern?

Answer:
- Handles complex object creation
- Improves readability
- Supports immutability
- Avoids constructor overloading
- Handles optional parameters cleanly


Q11: What are the disadvantages of Builder Pattern?

Answer:
- Requires extra code (builder class)
- Slightly more complex than simple constructors
- Not needed for simple objects


Q12: Can Builder Pattern be used with other patterns?

Answer:
Yes, it is often used with:
- Factory Pattern (factory returns builder)
- Singleton (builder creates singleton configuration)
- Prototype (builder helps cloning with modifications)


Q13: When should you use Builder Pattern?

Answer:
- When object has many optional fields
- When object creation is complex
- When immutability is required
- When constructor becomes too large or unreadable


Q14: How is this different from Factory Pattern?

Answer:
- Factory Pattern decides WHICH object to create
- Builder Pattern decides HOW to construct an object step by step


Q15: Is Builder Pattern thread-safe?

Answer:
The Builder itself is not thread-safe because it is mutable.
However, the final built object (Email) is thread-safe if it is immutable.


========================================
INTERVIEW SUMMARY
========================================

- Builder Pattern is used for constructing complex objects step-by-step.
- It avoids telescoping constructors and improves readability.
- It supports immutability by creating objects only through build().
- Best suited when there are many optional parameters.

*/
public class Main {
    public static void main(String[] args) {
        EmailBuilder builder = new EmailBuilder();
        Email email = builder
                .setTo("contact@gmail.com")
                .setSubject("Request for Proof")
                .setBody("Hi Satya, ....")
                .build();

        //email is immutable because it does not have setters and the attributes are private
        System.out.println(email.getTo());
    }
}
