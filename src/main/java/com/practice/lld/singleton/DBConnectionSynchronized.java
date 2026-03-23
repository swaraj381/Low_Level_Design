package com.practice.lld.singleton;

/*
Output: Connection to DB is established by Thread1
Or maybe Thread2 - whichever thread reaches first. But only one line will be printed.
This works, but it synchronizes the method every time, even when the object is already created. That can slow things down.
*/
public class DBConnectionSynchronized {
    private static DBConnectionSynchronized connection;

    private DBConnectionSynchronized(String name) {
        System.out.println("Creating DB Connection for " + name);
    }

    public static synchronized DBConnectionSynchronized getDBConnection(String name) {
        if (connection == null) {
            connection = new DBConnectionSynchronized(name);
        }
        return connection;
    }
}
