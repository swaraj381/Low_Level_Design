package com.practice.lld.singleton;
/*
========================================
EAGER SINGLETON - INTERVIEW Q&A
========================================

Q1: Why is Eager Singleton thread-safe?

Answer:
Eager Singleton is thread-safe because the instance is created during
class loading, and JVM guarantees that class initialization is
thread-safe. Internally, JVM uses a class-level lock to ensure that
only one thread initializes the class, so the instance is created only once.


Q2: Why is no synchronization needed in Eager Singleton?

Answer:
No explicit synchronization is required because the object is created
by the JVM during class loading itself. Since class loading is already
thread-safe, there is no possibility of multiple threads creating multiple
instances. Hence, we don't need to use synchronized blocks or methods.


Q3: When exactly is the instance created?

Answer:
The instance is created at the time of class loading, i.e., when the class
is first loaded into memory by the JVM. This happens even before any method
(such as getInstance()) is called.


Q4: Why is Eager Singleton considered inefficient sometimes?

Answer:
Eager Singleton creates the object even if it is never used in the application.
If the object is heavy (e.g., database connection, large memory object),
this can lead to unnecessary memory usage and increased startup time.


Q5: What are the pros of Eager Singleton?

Answer:
- Simple implementation
- Thread-safe without synchronization
- No overhead of locking or synchronization


Q6: What are the cons of Eager Singleton?

Answer:
- Instance is created even if not used
- Not suitable for heavy objects
- No lazy loading (no control over object creation timing)


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

public class DBConnectionEagerSingleton {
    // Instance created at class loading time
    private static final DBConnectionEagerSingleton instance = new DBConnectionEagerSingleton();

    private DBConnectionEagerSingleton() {
        System.out.println("EagerSingleton constructor");
    }

    public static DBConnectionEagerSingleton getInstance() {
        return instance;
    }
}
