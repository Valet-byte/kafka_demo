package com.valet.db_server.svrvice;

import com.valet.db_server.model.EmailMessage;

public interface EmailService {
    void sendEmail(EmailMessage emailMessage);
    void saveToDB(EmailMessage emailMessage);
}
