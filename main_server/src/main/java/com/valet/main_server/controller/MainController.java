package com.valet.main_server.controller;

import com.valet.main_server.model.User;
import com.valet.main_server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserService userService;

    @PostMapping("/registration")
    public boolean registration(@RequestBody User user){
        return userService.registration(user);
    }
}
