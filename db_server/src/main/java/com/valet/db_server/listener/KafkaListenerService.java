package com.valet.db_server.listener;

import com.valet.db_server.model.EmailMessage;
import com.valet.db_server.model.EmailType;
import com.valet.db_server.model.User;
import com.valet.db_server.svrvice.EmailService;
import com.valet.db_server.svrvice.UserService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaListenerService {
    private final UserService userService;
    private final EmailService emailService;

    @KafkaListener(topics = "registrationTopic")
    public void registrationUser(@Payload User user){
        User u = userService.registration(user);
        EmailMessage message = new EmailMessage(null, u.getEmail(), u.getName(), null, EmailType.HELLO_MESSAGE, null);
        emailService.sendEmail(message);
    }
}
