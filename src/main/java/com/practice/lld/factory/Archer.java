package com.practice.lld.factory;

public class Archer extends  Troop {
    private final int range;

    public Archer(){
        super("Archer", 100, 30);
        this.range = 5;
    }

    @Override
    public void attack() {
        System.out.println(name + " attacks from a distance with damage: " + damage);
    }

    @Override
    public void move() {
        System.out.println(name + " moves to a strategic position.");
    }
}
