package com.practice.lld.factory;

public abstract class Troop {
    protected String name;
    protected int health;
    protected int damage;

    public Troop(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public abstract void attack();
    public abstract void move();
}
