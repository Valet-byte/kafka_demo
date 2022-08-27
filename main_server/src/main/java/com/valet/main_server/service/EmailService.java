package com.valet.main_server.service;

import com.valet.main_server.model.DTO.EmailMessageDTO;
import com.valet.main_server.model.EmailMessage;

import java.util.List;

public interface EmailService {
    boolean sendOnUser(EmailMessage message);
    boolean sengOnPost(EmailMessage message);

    List<EmailMessageDTO> getMyMessage(String username);
}
