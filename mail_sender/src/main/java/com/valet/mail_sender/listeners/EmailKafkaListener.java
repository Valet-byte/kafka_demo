package com.valet.mail_sender.listeners;

import com.valet.mail_sender.model.EmailMessage;
import com.valet.mail_sender.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailKafkaListener {

    private final MailService mailService;

    @KafkaListener(topics = "sendEmailTopic")
    public void sendEmail(@Payload EmailMessage message){
        mailService.sendMessage(message);
    }
}
