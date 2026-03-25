package com.practice.lld.ChainOfResponsibility;


public class BehavioralInterview extends InterviewHandler {

    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    protected boolean hire(String candidate) {

        System.out.println("Behavioral round for " + candidate);
        int score = scanner.nextInt();

        if (score >= 60) {
            System.out.println(candidate + " cleared Behavioral\n");
            return true;
        }

        System.out.println(candidate + " failed Behavioral");
        return false;
    }
}
