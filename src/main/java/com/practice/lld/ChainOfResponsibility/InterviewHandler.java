package com.practice.lld.ChainOfResponsibility;

public abstract class InterviewHandler {

    protected InterviewHandler next;

    public void setNext(InterviewHandler next) {
        this.next = next;
    }

    public void handle(String candidate) {
        if (hire(candidate)) {
            if (next != null) {
                next.handle(candidate);
            } else {
                System.out.println(candidate + " passed all interviews!");
            }
        } else {
            System.out.println(candidate + " is rejected.");
        }
    }

    protected abstract boolean hire(String candidate);
}
