package com.practice.lld.ChainOfResponsibility;

public class BarRaiserInterview extends InterviewHandler {

    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    protected boolean hire(String candidate) {

        System.out.println("Bar Raiser round for " + candidate);
        int score = scanner.nextInt();

        if (score >= 80) {
            System.out.println(candidate + " cleared Bar Raiser\n");
            return true;
        }

        System.out.println(candidate + " failed Bar Raiser");
        return false;
    }
}
