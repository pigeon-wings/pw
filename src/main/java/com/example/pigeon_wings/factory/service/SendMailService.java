//package com.example.pigeon_wings.factory.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//
//@Service
//public class SendMailService {
//        @Autowired
//        private JavaMailSender mailSender;
//
//        public void sendNewMail(String to, String subject, String body) throws MessagingException {
////            MimeMessage message = mailSender.createMimeMessage();
////            MimeMessageHelper helper = new MimeMessageHelper(message, true);
////
////            helper.setTo(to);
////            helper.setSubject(subject);
////            helper.setText(body);
////
////            FileSystemResource file = new FileSystemResource(new File("D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html"));
////            helper.addAttachment("attachment1.jpg", file);
////
////            mailSender.send(message);
//
//        }
//}
