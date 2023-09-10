package org.example;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandlerBase {

    public void sendMail(){

        // Properties
        Properties systemPropertiesMap = System.getProperties();
//        System.out.println(systemPropertiesMap);

        systemPropertiesMap.put("mail.smtp.host","smtp.gmail.com");
        systemPropertiesMap.put("mail.smtp.port","465");
        systemPropertiesMap.put("mail.smtp.ssl.enable","true");
        systemPropertiesMap.put("mail.smtp.auth","true");

        // Authentication
        Authenticator mailAuthenticator = new CustomizedMailAuthenticator();

        // Session
        Session mailSession = Session.getInstance(systemPropertiesMap, mailAuthenticator);


        // Build the Mail
        // Mime message
        MimeMessage mailMessage = new MimeMessage(mailSession);
        try {

            mailMessage.setFrom(MailConstants.SENDER);
            mailMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress("niraj40patil@gmail.com")));
            mailMessage.setSubject("Remind You");
            mailMessage.setText("Hey Donkey! This mail is just for reminding you that you are 'unplanned' baby. You bastard.");

            Transport.send(mailMessage);
        }catch (Exception ex){
            System.out.println("Some errors while preparing mail body");
            System.out.println(ex.getMessage());
        }
    }

}
