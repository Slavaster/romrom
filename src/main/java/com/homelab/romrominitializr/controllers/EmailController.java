package com.homelab.romrominitializr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import static org.aspectj.bridge.Version.text;

@Controller
public class EmailController {

    @PostMapping("send-email")
    public String sendEmail(@RequestParam String recipient, @RequestParam String messageSubject, @RequestParam String messageText){

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.ukr.net");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get the Session object.
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("savikforever@ukr.net","2008");
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("savikforever@ukr.net"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            message.setSubject(messageSubject);
            message.setText(messageText);

            Transport.send(message);

            System.out.println("Message to "+recipient+" sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return "pages/mailForm.jsp";

    }

}
