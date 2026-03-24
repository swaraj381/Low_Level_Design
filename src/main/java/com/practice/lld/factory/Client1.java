package com.practice.lld.factory;

import java.util.Scanner;

/*
Now, adding a new troop (like "Giant") only requires changes to the TroopFactory, not every client.

It's a good practice to use an enum in combination with the Factory pattern to eliminate errors in the if-else logic.
With enums, you can avoid potential mistakes and keep things more streamlined.


Key Benefits of Using the Factory Design Pattern
Before watching, make sure you give it a try
Loose Coupling: Clients don't worry about how objects are created. They just ask for one.
Scalability: Adding new troops doesn't disturb existing client code.
Maintainability: Object creation logic is neatly packed into one place - the Factory.
Flexibility: Factory can easily switch the type of troop being returned (for example, based on player level or troop upgrades).


========================================
FACTORY DESIGN PATTERN - INTERVIEW Q&A
========================================

Q1: What problem does the Factory Design Pattern solve?

Answer:
Factory Pattern removes the responsibility of object creation from the client.
Instead of directly creating objects using 'new', the client asks a factory
to provide the required object. This promotes loose coupling and better design.


Q2: Where is the Factory in this implementation?

Answer:
The TroopFactory class acts as the factory. It contains the logic to decide
which concrete Troop object (Archer, Barbarian, etc.) should be created
based on the input provided by the client.


Q3: What is the role of the abstract class (Troop)?

Answer:
The Troop class defines a common contract (attack, move) for all troop types.
All concrete classes (Archer, Barbarian, etc.) extend this class and provide
their own implementation, enabling polymorphism.


Q4: How does this design achieve loose coupling?

Answer:
The client depends only on the abstract class (Troop) and not on concrete
implementations like Archer or Barbarian. This means changes in concrete
classes do not affect the client code.


Q5: Is this implementation following Open-Closed Principle (OCP)?

Answer:
Partially. While new troop classes can be added without modifying client code,
the factory class still needs to be updated (if-else or switch case) to handle
new types. This violates OCP.


Q6: How can we improve this design to fully follow OCP?

Answer:
We can use a Map-based or registration-based factory approach, where new troop
types are registered dynamically without modifying existing factory logic.
This removes the need for if-else or switch statements.


Q7: What happens if an invalid troop type is provided?

Answer:
If not handled properly, the factory may return null, leading to
NullPointerException when methods like attack() or move() are called.
We should handle this by throwing a meaningful exception.


Q8: Why not directly create objects using 'new' in the client?

Answer:
Direct object creation tightly couples the client with concrete classes.
Factory Pattern abstracts object creation, making the system more flexible,
maintainable, and scalable.


Q9: Where is polymorphism used in this design?

Answer:
Polymorphism is used when the client holds a reference of type Troop
but the actual object can be Archer, Barbarian, etc.
Example:
Troop troop = TroopFactory.createTroop(type);


Q10: Can this factory be extended to support dynamic behavior?

Answer:
Yes. The factory can include logic based on conditions such as user level,
game state, or configuration to decide which object to create dynamically.


Q11: What are the advantages of Factory Pattern?

Answer:
- Loose coupling between client and object creation
- Centralized object creation logic
- Easy to extend and maintain
- Improves code readability and flexibility


Q12: What are the disadvantages of Factory Pattern?

Answer:
- Factory class can become complex if too many types are added
- Violates OCP if not designed properly (using if-else or switch)
- Adds an extra layer of abstraction


Q13: What is the difference between Factory and Abstract Factory?

Answer:
- Factory Pattern creates a single object based on input
- Abstract Factory creates families of related objects


Q14: How can we make this design safer and avoid input errors?

Answer:
Instead of using raw strings, we can use enums to represent troop types.
This avoids typos and makes the code more robust.


Q15: Can Factory Pattern be combined with other patterns?

Answer:
Yes. Factory Pattern is often used with:
- Singleton (factory instance)
- Strategy (to select behavior dynamically)
- Abstract Factory (for creating families of objects)


========================================
INTERVIEW SUMMARY
========================================

- Factory Pattern decouples object creation from client usage.
- Client interacts with abstraction, not concrete classes.
- Improves maintainability, scalability, and flexibility.
- Can be optimized using Map, Enum, or Registration-based approaches.


*/
public class Client1 {
    public static void main(String[] args) {
        TroopFactoryWithMap.registerTroop("giant", Giant::new);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Each troop type(Barbarian, Archer, Wizard, HogRider):");
        String type = scanner.nextLine();

        // Troop troop =TroopFactory.createTroop(type); (not for map based approach)
        Troop troop = TroopFactoryWithMap.createTroop(type);



        troop.move();
        troop.attack();

        scanner.close();
    }
}
