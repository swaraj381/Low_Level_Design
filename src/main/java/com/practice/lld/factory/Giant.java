package com.practice.lld.factory;

public class Giant extends Troop {
    public Giant() {
        super("Giant", 300, 40);
    }

    @Override
    public void move() {
        System.out.println("Giant move");
    }

    @Override
    public void attack(){
        System.out.println("Giant attack" + damage);
    }
}
