package me.kainar.awsm.service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    private Session mailSession;

    public void sendEmail(String reciver,String subject, String content) throws MessagingException {
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("200103447@stu.sdu.edu.kz"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(reciver));
        message.setSubject(subject);
        message.setText("fuck u");
        Transport.send(message);
    }

    @Autowired
    public void setMailSession(Session mailSession) {
        this.mailSession = mailSession;
    }
}
