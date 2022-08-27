package com.valet.main_server.repo;

import com.valet.main_server.model.EmailMessage;

import java.util.List;

public interface EmailRepo {
    List<EmailMessage> getMyEmail(String username);
}
