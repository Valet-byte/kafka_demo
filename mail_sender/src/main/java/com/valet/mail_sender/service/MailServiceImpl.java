package com.valet.mail_sender.service;

import com.valet.mail_sender.model.EmailMessage;
import com.valet.mail_sender.model.EmailType;
import com.valet.mail_sender.service.sender.Sender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MailServiceImpl implements MailService {

    private final Map<EmailType, Sender> senderMap;

    private MailServiceImpl(List<Sender> senders){
        senderMap = senders.stream().collect(Collectors.toMap(Sender::getMyType, sender -> sender));
    }

    @Override
    public void sendMessage(EmailMessage message) {
        senderMap.get(message.getEmailType()).send(message);
    }
}
