package com.practice.lld.factory;

public class Barbarian extends Troop{

    public Barbarian() {
        super("Barbarian", 150, 50);
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks with damage: " + damage);
    }
    @Override
    public void move() {
        System.out.println(name + " moves towards the enemy.");
    }
}
