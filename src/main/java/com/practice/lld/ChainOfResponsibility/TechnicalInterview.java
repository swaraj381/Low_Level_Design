package com.practice.lld.ChainOfResponsibility;

import java.util.Scanner;

public class TechnicalInterview extends InterviewHandler {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected boolean hire(String candidate) {

        System.out.println("Technical round for " + candidate);
        int score = scanner.nextInt();

        if (score >= 70) {
            System.out.println(candidate + " cleared Technical Interview\n");
            return true;
        }

        System.out.println(candidate + " failed Technical Interview");
        return false;
    }
}
