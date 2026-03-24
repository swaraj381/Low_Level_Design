package com.practice.lld.factory;

public class HogRider extends  Troop{

    public HogRider() {
        super("Hog Rider", 200, 60);
    }

    @Override
    public void attack() {
        System.out.println(name + " charges with damage: " + damage);
    }
    @Override
    public void move() {
        System.out.println(name + " rides towards the enemy.");
    }
}
