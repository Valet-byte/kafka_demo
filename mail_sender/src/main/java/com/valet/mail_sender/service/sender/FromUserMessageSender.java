package com.valet.mail_sender.service.sender;

import com.valet.mail_sender.model.EmailMessage;
import com.valet.mail_sender.model.EmailType;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FromUserMessageSender implements Sender {
    private final JavaMailSender mailSender;

    @Override
    public void send(EmailMessage emailMessage) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("valetbyte22@gmail.com");
        simpleMailMessage.setTo(emailMessage.getEmail());
        simpleMailMessage.setSubject(emailMessage.getFromUserName());
        simpleMailMessage.setText("Message from  " + emailMessage.getUsername());
        mailSender.send(simpleMailMessage);
    }

    @Override
    public EmailType getMyType() {
        return EmailType.FROM_USER_MESSAGE;
    }
}
