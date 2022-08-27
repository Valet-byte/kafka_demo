package com.valet.main_server.repo;

import com.valet.main_server.model.User;

public interface UserRepo {
    User findByName(String username);
    boolean existsUser(User user);
}
