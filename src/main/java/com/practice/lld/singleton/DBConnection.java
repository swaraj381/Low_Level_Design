package com.practice.lld.singleton;

/*
This code won't work on a multithreaded environment

Common Questions Asked:-
1. The constructor is private so how is the DBConnection object created?
Good catch! Since the constructor is private, no one outside the class can directly create an object using new DBConnection(...)
But we're providing a static method getDBConnection() that belongs to the class itself. So, instead of using new, we call: DBConnection.getDBConnection(...)
This method handles the object creation inside the class, and returns it to us.

2. What if I call getDBConnection() multiple times? Will it create multiple objects?
Nope! That's the beauty of Singleton.

          if (connection == null) {
             connection = new DBConnection(name);
             }

This ensures that the object is created only once. After that, the same object is reused no matter how many times you call getDBConnection().

3.Got it! But how do I actually use or access this object?
It's super simple. Since the method getDBConnection() returns the object, you can just use it like this:
DBConnection db1 = DBConnection.getDBConnection("Client1");
DBConnection db2 = DBConnection.getDBConnection("Client2");
Output: Connection to DB is established by Client1
Even though you're calling the method twice with different names, only the first call creates the object. That's why "Connection to DB is established by Client1" is printed only once.
The second call simply returns the already created instance so "Client2" has no effect on object creation or output.
*/
public class DBConnection {
    private static DBConnection connection;

    private DBConnection(String name) {
        System.out.println("Creating DB Connection for " + name);
    }

    public static DBConnection getDBConnection(String name) {
        if (connection == null) {
            connection = new DBConnection(name);
        }
        return connection;
    }
}