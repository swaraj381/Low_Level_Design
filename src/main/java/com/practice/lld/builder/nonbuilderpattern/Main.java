package com.practice.lld.builder.nonbuilderpattern;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Email Creation with Optional Fields ===");

        // 1. Simple email with just to, subject, and body
        Email simpleEmail = new Email(
            "user@example.com",
            "Hello",
            "This is a simple email message."
        );
        System.out.println("Simple Email:");
        System.out.println("To: " + simpleEmail.getTo());
        System.out.println("Subject: " + simpleEmail.getSubject());
        System.out.println("Body: " + simpleEmail.getBody());
        System.out.println("CC: " + simpleEmail.getCc());
        System.out.println("BCC: " + simpleEmail.getBcc());
        System.out.println("Attachments: " + simpleEmail.getAttachments());
        System.out.println();

        // 2. Email with CC
        Email emailWithCC = new Email(
            "user@example.com",
            "Meeting Invitation",
            "Please join our meeting tomorrow.",
            "manager@example.com"
        );
        System.out.println("Email with CC:");
        System.out.println("To: " + emailWithCC.getTo());
        System.out.println("Subject: " + emailWithCC.getSubject());
        System.out.println("Body: " + emailWithCC.getBody());
        System.out.println("CC: " + emailWithCC.getCc());
        System.out.println("BCC: " + emailWithCC.getBcc());
        System.out.println("Attachments: " + emailWithCC.getAttachments());
        System.out.println();

        // 3. Email with attachments only
        List<String> attachments = Arrays.asList("document.pdf", "image.jpg");
        Email emailWithAttachments = new Email(
            "user@example.com",
            "Project Files",
            "Please find attached project files.",
            attachments
        );
        System.out.println("Email with Attachments:");
        System.out.println("To: " + emailWithAttachments.getTo());
        System.out.println("Subject: " + emailWithAttachments.getSubject());
        System.out.println("Body: " + emailWithAttachments.getBody());
        System.out.println("CC: " + emailWithAttachments.getCc());
        System.out.println("BCC: " + emailWithAttachments.getBcc());
        System.out.println("Attachments: " + emailWithAttachments.getAttachments());
        System.out.println();

        // 4. Email with CC and attachments
        Email emailWithCCAndAttachments = new Email(
            "user@example.com",
            "Updated Project Files",
            "Please review the updated project files.",
            "team@example.com",
            attachments
        );
        System.out.println("Email with CC and Attachments:");
        System.out.println("To: " + emailWithCCAndAttachments.getTo());
        System.out.println("Subject: " + emailWithCCAndAttachments.getSubject());
        System.out.println("Body: " + emailWithCCAndAttachments.getBody());
        System.out.println("CC: " + emailWithCCAndAttachments.getCc());
        System.out.println("BCC: " + emailWithCCAndAttachments.getBcc());
        System.out.println("Attachments: " + emailWithCCAndAttachments.getAttachments());
        System.out.println();

        // 5. Large constructor with ALL fields (demonstrating the problem)
        System.out.println("=== Large Constructor Creation (All Fields) ===");
        Email fullEmail = new Email(
            "recipient@example.com",           // to
            "Important Business Proposal",     // subject
            "Dear Sir/Madam,\n\nPlease find attached our business proposal for your review.\n\nBest regards,\nJohn Doe", // body
            "manager@example.com",             // cc
            "secretary@example.com",           // bcc
            Arrays.asList("proposal.pdf", "financials.xlsx", "presentation.pptx") // attachments
        );

        System.out.println("Full Email (All Fields):");
        System.out.println("To: " + fullEmail.getTo());
        System.out.println("Subject: " + fullEmail.getSubject());
        System.out.println("Body: " + fullEmail.getBody());
        System.out.println("CC: " + fullEmail.getCc());
        System.out.println("BCC: " + fullEmail.getBcc());
        System.out.println("Attachments: " + fullEmail.getAttachments());
        System.out.println();

        // Demonstrate the problem: what if we want to create an email with only BCC?
        // We can't do this easily with current constructors - we'd have to pass nulls
        System.out.println("=== Problem Demonstration ===");
        System.out.println("What if we want to create an email with ONLY BCC field set?");
        System.out.println("We'd have to do: new Email(to, subject, body, null, bcc, null)");
        System.out.println("This is messy and error-prone!");
        System.out.println("This is why the Builder pattern is preferred for complex objects with many optional fields.");
    }
}
