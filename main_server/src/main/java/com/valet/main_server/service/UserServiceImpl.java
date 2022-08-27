package com.valet.main_server.service;

import com.valet.main_server.model.User;
import lombok.AllArgsConstructor;
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

    @Override
    public boolean registration(User user) {
        if (user.getName().split(" ").length == 3 &&
            user.getEmail() != null && user.getPassword() != null && !user.getPassword().equals("")
                && !user.getEmail().equals("")){

            user.setPassword(encoder.encode(user.getPassword()));
            template.send("registrationTopic", user).addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onFailure(Throwable ex) {
                    ex.printStackTrace();
                }

                @Override
                public void onSuccess(SendResult<String, User> result) {

                }
            });
            return true;
        }
        return false;
    }
}
