package com.practice.lld.singleton;

public class Main {
    public static void main(String[] args) {
        DBConnection db1 = DBConnection.getDBConnection("Client1");
        DBConnection db2 = DBConnection.getDBConnection("Client2");
    }
}