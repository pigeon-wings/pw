package com.example.pigeon_wings;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendAutoEmail {
    public void sendReportEmail() throws EmailException {

        System.out.println("===Test for Sending CommonsEmail started===");
        // Create the attachment
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("D:\\SpringBootCourse\\IntellijWorkSpace\\screenshotStore\\report_nop.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Picture of bad indentation");
        attachment.setName("BadIndentation");
        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("hazzatun.jahan@gmail.com", "U@hazzatun123"));
        email.setSSLOnConnect(true);
        email.setFrom("CommonsEmail@gmail.com");
        email.setSubject("CommonsEmail Test");
        email.setMsg("CommonsEmail test mail ... :-)");
        email.addTo("bandhan.cse@gmail.com");
        // add the attachment
        email.attach(attachment);
        // send the email
        email.send();
        System.out.println("===Test for Sending CommonsEmail ended===");
    }
}
