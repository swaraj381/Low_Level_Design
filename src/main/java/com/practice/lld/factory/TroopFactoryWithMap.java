package com.practice.lld.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/*
========================================
MAP-BASED FACTORY - INTERVIEW Q&A
========================================

Q1: What is Map-based Factory?

Answer:
Instead of using if-else or switch statements, we use a Map to store
type -> object creation logic. This removes conditional complexity
and makes the design scalable.


Q2: How does this follow Open-Closed Principle (OCP)?

Answer:
New troop types can be added by simply registering them in the map
without modifying existing factory logic. Hence, the factory is
closed for modification but open for extension.


Q3: Why are we using Supplier<Troop>?

Answer:
Supplier is a functional interface that represents a function which
returns an object. Here, it stores object creation logic (like Archer::new),
allowing lazy instantiation.


Q4: What is the advantage over if-else?

Answer:
- No long conditional chains
- Cleaner and more maintainable code
- Easy to extend dynamically


Q5: Can we register new troop types at runtime?

Answer:
Yes, using registerTroop() method, new troop types can be added dynamically
without changing factory code.


========================================
*/
public class TroopFactoryWithMap {

    // Map to store troop type -> object creator
    private static final Map<String, Supplier<Troop>> registry = new HashMap<>();

    // Static block to register default troop types
    static {
        registry.put("archer", Archer::new);
        registry.put("barbarian", Barbarian::new);
        registry.put("giant", Giant::new);
    }

    // Factory method
    public static Troop createTroop(String type) {

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Troop type cannot be null or empty");
        }

        Supplier<Troop> supplier = registry.get(type.toLowerCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Invalid troop type: " + type);
        }

        return supplier.get();
    }

    // Method to register new troop dynamically
    public static void registerTroop(String type, Supplier<Troop> supplier) {

        if (type == null || supplier == null) {
            throw new IllegalArgumentException("Type or Supplier cannot be null");
        }

        registry.put(type.toLowerCase(), supplier);
    }
}
