package com.innovationem.service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    static String FROM_EMAIL_ADDRESS = "muraalee@gmail.com";
    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);

    public void sendEmail(String toAddress, String toName, String subject, String body) {
        try {
            if (toName == null) toName = "Dear User";
            else toName = "Dear " + toName;
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM_EMAIL_ADDRESS, "myStoredLife"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress, toName));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
