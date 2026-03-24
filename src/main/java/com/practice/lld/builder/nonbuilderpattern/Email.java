package com.practice.lld.builder.nonbuilderpattern;

import java.util.List;

/*
Here, we're using only getters and no setters, so no one can modify the email once it's created. This makes the class immutable. So far so good.

But there's a big issue...

Common Problems Without Builder
1. Passing null values
What if you don't want to set cc, bcc, or attachments?

Then you'll end up doing this:

Email email = new Email(
"contact@nailyourinterview.org", "Request for course On SpringBoot", "Hi Shubh,......", null,
null,
null
);

Now imagine your class has 30 attributes, but you only want to set 5. That means you'll have to pass 25 null values - which is messy and confusing.

2
Constructor Overload (Too Many Constructors)
To avoid passing null, some developers create multiple constructors:
public class Email {
// some might prefer just subject and body
public Email(String to, String subject, String body) {
    this(to, subject, body, null, null, null);
}
// some might prefer subject, body and cc
public Email(String to, String subject, String body, String cc) {
    this(to, subject, body, cc, null, null);
}
// some might prefer subject, body, cc and attachments
public Email(String to, String subject, String body, String cc, List<String> attachments) {
    this(to, subject, body, cc, null, attachments);
}
// some might prefer subject, body, attachments but not cc
public Email(String to, String subject, String body, List<String> attachments) {
    this(to, subject, body, null, null, attachments);
}
// some might use all
public Email(String to, String subject, String body, String cc, String bcc, List<String> attachments) {
    this.to = to;
    this.subject = subject;
    this.body = body;
    this.cc = cc;
    this.bcc = bcc;
    this.attachments = attachments;
}

This leads to Constructor Explosion - creating many constructors just to handle different combinations of fields. The number of constructors grows very fast when you add more fields.


*/
public class Email {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments;

    public Email(String to, String subject, String body, String cc, String bcc, List<String> attachments) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.attachments = attachments;
    }

    public Email(String to, String subject, String body) {
        this(to, subject, body, null, null, null);
    }

    public Email(String to, String subject, String body, String cc) {
        this(to, subject, body, cc, null, null);
    }

    public Email(String to, String subject, String body, String cc, List<String> attachments) {
        this(to, subject, body, cc, null, attachments);
    }

    public Email(String to, String subject, String body, List<String> attachments) {
        this(to, subject, body, null, null, attachments);
    }

    // Manual getter methods since Lombok is not available in manual compilation
    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    public List<String> getAttachments() {
        return attachments;
    }
}
