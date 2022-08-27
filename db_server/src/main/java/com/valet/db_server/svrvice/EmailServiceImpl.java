package com.valet.db_server.svrvice;

import com.valet.db_server.model.EmailMessage;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final KafkaTemplate<String, EmailMessage> template;

    @Override
    public void sendEmail(EmailMessage emailMessage) {
        template.send("sendEmailTopic", emailMessage);
    }
}
