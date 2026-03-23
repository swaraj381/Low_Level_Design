package com.practice.lld.singleton;

/*
Output: Connection to DB is established by Thread1
Or maybe Thread2 - whichever thread reaches first. But only one line will be printed.
This works, but it synchronizes the method every time, even when the object is already created. That can slow things down.

========================================
LAZY SINGLETON - INTERVIEW Q&A
========================================

Q7: Why is basic Lazy Singleton not thread-safe?

Answer:
In Lazy Singleton, the instance is created only when getInstance() is called.
If multiple threads call getInstance() at the same time, they can pass the
null check simultaneously and create multiple instances, breaking the singleton.


Q8: Explain the race condition in Lazy Singleton.

Answer:
If two threads check 'instance == null' at the same time, both will find it true.
Both threads will then create a new object, resulting in multiple instances.
This is called a race condition.


Q9: How can we make Lazy Singleton thread-safe?

Answer:
We can make it thread-safe by using:
1. synchronized method
2. synchronized block
3. Double-checked locking (best approach)


Q10: What is the drawback of using synchronized method?

Answer:
Using synchronized on the entire method ensures thread safety, but it causes
performance issues because every thread must acquire the lock even after the
instance is already created.


Q11: What is Double-Checked Locking?

Answer:
Double-checked locking checks if the instance is null before and after acquiring
the lock. This reduces unnecessary synchronization and improves performance.


Q12: Why is 'volatile' required in Double-Checked Locking?

Answer:
The 'volatile' keyword prevents instruction reordering by the JVM.
Without volatile, a thread might see a partially constructed object,
leading to unpredictable behavior.


Q13: When should we prefer Lazy Singleton over Eager Singleton?

Answer:
Lazy Singleton should be preferred when:
- Object creation is expensive
- Object may not always be needed
- We want to delay initialization until it's actually required


========================================
INTERVIEW SUMMARY
========================================

- Eager Singleton:
  Thread-safe, simple, but creates object even if not used.

- Lazy Singleton:
  Saves memory but needs careful handling for thread safety.

- Best Practice:
  Use Double-Checked Locking or Enum Singleton in real-world applications.

*/
public class DBConnectionLazySingleton {
    private static DBConnectionLazySingleton connection;

    private DBConnectionLazySingleton(String name) {
        System.out.println("Creating DB Connection for " + name);
    }

    public static synchronized DBConnectionLazySingleton getDBConnection(String name) {
        if (connection == null) {
            connection = new DBConnectionLazySingleton(name);
        }
        return connection;
    }
}
