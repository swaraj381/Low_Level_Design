package com.practice.lld.factory.client;

import com.practice.lld.factory.Archer;
import com.practice.lld.factory.Barbarian;
import com.practice.lld.factory.HogRider;
import com.practice.lld.factory.Troop;
import com.practice.lld.factory.Wizard;

import java.util.Scanner;

/*
The Problems with This Approach
1. Same messy if-else repeated across multiple clients.
Currently, we have just 4 troops. But imagine having hundreds of troops - the if-else logic would be massive!

2. Adding a new troop (like Giant) would require updating every client manually.
You'd need to add it to each client that's using the if-else logic.

3. Code becomes hard to maintain and error-prone.
With so much repetition, mistakes are bound to happen.

*/
public class Client1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Each troop type(Barbarian, Archer, Wizard, HogRider):");
        String type = scanner.nextLine();
        
        Troop troop;
        
        if (type.equalsIgnoreCase("Barbarian")) {
            troop = new Barbarian();
        } else if (type.equalsIgnoreCase("Archer")) {
            troop = new Archer();
        } else if (type.equalsIgnoreCase("Wizard")) {
            troop = new Wizard();
        } else if (type.equalsIgnoreCase("HogRider")) {
            troop = new HogRider();
        } else {
            throw new IllegalArgumentException("Unknown troop type" + type);
        }
        troop.move();
        troop.attack();
        
        scanner.close();
    }
}
