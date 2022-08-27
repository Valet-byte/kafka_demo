package com.valet.main_server.service;

import com.valet.main_server.model.DTO.EmailMessageDTO;
import com.valet.main_server.model.EmailMessage;
import com.valet.main_server.repo.EmailRepo;
import com.valet.main_server.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final KafkaTemplate<String, EmailMessage> template;
    private final EmailRepo emailRepo;
    private final UserRepo userRepo;

    @Override
    public boolean sendOnUser(EmailMessage message) {
        if (message.getValue().length() < 800){
            template.send("sendInDBTopic", message);
            return true;
        }
        return false;
    }

    @Override
    public boolean sengOnPost(EmailMessage message) {
        if (message.getValue().length() < 800){
            message.setEmail(userRepo.getEmailByName(message.getUsername()));
            template.send("sendEmailTopic", message);
            return true;
        }
        return false;
    }

    @Override
    public List<EmailMessageDTO> getMyMessage(String username) {
        return emailRepo.getMyEmail(username).stream().map(EmailMessage::toDTO).toList();
    }
}
