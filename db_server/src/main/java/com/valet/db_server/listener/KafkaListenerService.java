package com.valet.db_server.listener;

import com.valet.db_server.model.User;
import com.valet.db_server.svrvice.UserService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaListenerService {
    private final UserService userService;

    @KafkaListener(id = "1", topics = "registrationTopic")
    public void registrationUser(@Payload User user){
        User u = userService.registration(user);
    }
}
