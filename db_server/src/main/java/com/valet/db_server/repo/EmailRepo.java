package com.valet.db_server.repo;

import com.valet.db_server.model.EmailMessage;

public interface EmailRepo {
    void save(EmailMessage message);
}
