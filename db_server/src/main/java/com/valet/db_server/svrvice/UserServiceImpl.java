package com.valet.db_server.svrvice;

import com.valet.db_server.model.User;
import com.valet.db_server.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User registration(User user) {
        return userRepo.registration(user);
    }
}
