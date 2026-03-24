package com.practice.lld.builder.builderpattern;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/*
Our goal is to create immutable Email class so even if Email Builder has setters, we dont mind. Checkout the build() function.
This build() function is responsible to create the immutable Email object.
So only way to create Email is to first create Builder and set all the required attributes and at last call the build() method which takes in the builder object as parameter.
*/
@Getter
public class EmailBuilder {
    private String to;
    private String subject;
    private String body;
    private String cc;
    private String bcc;
    private List<String> attachments= new ArrayList<>();

    public EmailBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public EmailBuilder setCc(String cc) {
        this.cc = cc;
        return this;
    }

    public EmailBuilder setBcc(String bcc) {
        this.bcc = bcc;
        return this;
    }

    public EmailBuilder addAttachment(String fileName) {
        this.attachments.add(fileName);
        return this;
    }

    public Email build() {
        if (to == null) {
            throw new IllegalStateException("To field is required");
        }
        return new Email(this);
    }
}
