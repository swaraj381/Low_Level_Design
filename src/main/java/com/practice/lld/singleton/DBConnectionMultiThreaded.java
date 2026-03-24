package com.practice.lld.singleton;

/*
Here's how this works:
1. First check (outside synchronized) avoids locking unnecessarily.
2. Second check (inside synchronized) ensures only one thread creates the object.
Here, we have locked only the small block of function in DBConnection Class Object.

Why We Need volatile
You may wonder: what's the need for volatile?
1 Thread Caching Problem
Threads often cache the variables. So, Thread A might create the object, but Thread B could still see connection as null because it hasn't updated its cache.
2.Due to compiler and CPU optimizations, the JVM might reorder instructions for performance.

      connection = new DBConnectionMultiThreaded(name);

The above line is not a single operation. It's actually:
1. Allocate memory for the object
2. Initialize the object (run constructor)
3. Set connection to point to that memory
Due to JVM optimizations, steps 2 and 3 might be reordered like this:
1. Allocate memory
2. Set connection to point to that memory (A before it's initialized!)
3. Run the constructor

So now:
Thread A currently on step 3 is still initializing the object (running constructor)

Thread B at the same time comes in and says: "Oh cool! connection is not null (since step 2 pointed connection to memory) - I'll use it now!"

Thread B at the same time comes in and says: "Oh cool! connection is not null (since step 2 pointed connection to memory) - I'll use it now!"

But it's using an object that hasn't finished being constructed yet. That's what we mean by a "half-constructed object". The reference exists, but the object internals are still being built.

Declaring connection as volatile prevents caching and reordering. It ensures every read sees the most up-to-date and fully initialized object.
*/
public class DBConnectionMultiThreaded {
    private static volatile DBConnectionMultiThreaded instance;

    public DBConnectionMultiThreaded(String dbName) {
        System.out.println("Creating DB Connection for " + dbName);
    }

    static DBConnectionMultiThreaded getDBConnection(String dbName) {
        //Double check locking
        if (instance == null) {
            synchronized (DBConnectionMultiThreaded.class) {
                if (instance == null) {
                    instance = new DBConnectionMultiThreaded(dbName);
                }
            }
        }
        return instance;
    }
}