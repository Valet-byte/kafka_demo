package com.valet.main_server.controller;

import com.valet.main_server.model.DTO.EmailMessageDTO;
import com.valet.main_server.model.EmailMessage;
import com.valet.main_server.model.EmailType;
import com.valet.main_server.model.User;
import com.valet.main_server.service.EmailService;
import com.valet.main_server.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {

    private final UserService userService;
    private final EmailService emailService;

    @PostMapping("/registration")
    public boolean registration(@RequestBody User user){
        return userService.registration(user);
    }

    @GetMapping("/login")
    public User login(@AuthenticationPrincipal User user){
        user.setPassword("NONE");
        return user;
    }

    @GetMapping("/getMyEmails")
    public List<EmailMessageDTO> getMyEmails(@AuthenticationPrincipal User user){
        return emailService.getMyMessage(user.getUsername());
    }

    @PostMapping("/sendMessage")
    public boolean sendMessage(@AuthenticationPrincipal User user,
                               @RequestBody String value,
                               @RequestParam String toUser){
        EmailMessage message = new EmailMessage(null, null, toUser, user.getName(), EmailType.FROM_USER_MESSAGE, value);
        return emailService.sendOnUser(message);
    }

    @PostMapping("/sendToEmail")
    public boolean sendToEmail(@AuthenticationPrincipal User user,
                               @RequestBody String value,
                               @RequestParam String toUser){
        EmailMessage message = new EmailMessage(null, null, toUser, user.getName(), EmailType.FROM_USER_MESSAGE, value);
        return emailService.sengOnPost(message);
    }
}
