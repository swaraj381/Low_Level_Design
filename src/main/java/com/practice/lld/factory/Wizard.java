package com.practice.lld.factory;

public class Wizard extends Troop{

    public Wizard() {
        super("Wizard", 120, 70);
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a spell with damage: " + damage);
    }
    @Override
    public void move() {
        System.out.println(name + " floats towards the enemy.");
    }
}
