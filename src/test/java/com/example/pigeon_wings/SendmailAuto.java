package com.example.pigeon_wings;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendmailAuto {
    public static void main(String[] args) throws MessagingException, IOException {
        String username="hazzatun.jahan@gmail.com";
        String password="dlhb urmd vjdr tqgj";
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.debug", true);
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

       // Session session = Session.getInstance(props, auth);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessage helper = new MimeMessage(message);

        helper.setFrom(new InternetAddress(username));
       // helper.setTo("bandhan.cse@gmail.com");
        helper.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("bandhan.cse@gmail.com"));
        helper.setSubject("It is subject");
        helper.setText("It is body");
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File("D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html"));
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(attachmentBodyPart);
        helper.setContent(multipart);

        mailSender.send(helper);

    }

}
