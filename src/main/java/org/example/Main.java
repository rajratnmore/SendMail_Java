package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to Send Mail...");
        MailHandlerBase mailHandlerBase = new MailHandlerBase();
        mailHandlerBase.sendMail();
    }
}