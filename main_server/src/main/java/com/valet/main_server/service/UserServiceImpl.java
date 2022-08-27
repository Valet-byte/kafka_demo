package com.valet.main_server.service;

import com.valet.main_server.model.User;
import com.valet.main_server.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final KafkaTemplate<String, User> template;
    private final UserRepo userRepo;

    @Override
    public boolean registration(User user) {
        if (user.getName().split(" ").length == 3 &&
            user.getEmail() != null && user.getPassword() != null && !user.getPassword().equals("")
                && !user.getEmail().equals("")){

            if (!userRepo.existsUser(user)){
                user.setPassword(encoder.encode(user.getPassword()));
                template.send("registrationTopic", user).addCallback(new ListenableFutureCallback<>() {
                    @Override
                    public void onFailure(@NonNull Throwable ex) {
                        ex.printStackTrace();
                    }

                    @Override
                    public void onSuccess(SendResult<String, User> result) {

                    }
                });
                return true;
            }
        }
        return false;
    }
}
