package com.valet.db_server.svrvice;

import com.valet.db_server.model.EmailMessage;

public interface EmailService {
    public void sendEmail(EmailMessage emailMessage);
}
