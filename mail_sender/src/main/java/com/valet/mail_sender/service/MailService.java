package com.valet.mail_sender.service;

import com.valet.mail_sender.model.EmailMessage;

public interface MailService {
    void sendMessage(EmailMessage message);
}
