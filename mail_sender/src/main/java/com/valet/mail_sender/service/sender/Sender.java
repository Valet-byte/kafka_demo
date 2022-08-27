package com.valet.mail_sender.service.sender;

import com.valet.mail_sender.model.EmailMessage;
import com.valet.mail_sender.model.EmailType;

public interface Sender {
    void send(EmailMessage emailMessage);
    EmailType getMyType();
}
