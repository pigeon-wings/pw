package com.example.pigeon_wings;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendAutoEmail {
    public static void main(String[] args) throws IOException, MessagingException {
        sendReportEmail();
    }

    public static void sendReportEmail() throws IOException, MessagingException {
        String username = "hazzatun.jahan@gmail.com";
        String password = "U@hazzatun123";
        String fileName = "D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html";
        String to = "bandhan.cse@gmail.com";

        System.out.println("===Test for Sending CommonsEmail started===");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(username);
        mailSender.setPassword("dlhb urmd vjdr tqgj");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.debug", true);

//        Authenticator auth=new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        };
//
//        Session session = Session.getInstance(props, auth);

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(username);
        helper.setTo(to);
        helper.setSubject("subject");
        helper.setText("Body");

        // attach the file
        FileSystemResource file = new FileSystemResource(new File(fileName));
        helper.addAttachment("report_nop.html", file);//image will be sent by this name

        mailSender.send(message);



        System.out.println("===Test for Sending CommonsEmail ended===");
            System.out.println("Sent message successfully....");
        }
    }

