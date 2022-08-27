package com.valet.main_server.config;

import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @SneakyThrows
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        return http.csrf().disable().httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login", "/sendMessageToEmail", "/sendMessage", "/getMyEmails").authenticated()
                .and()
                .sessionManagement().disable()
                .build();
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("registrationTopic")
                .partitions(10)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic emailTopic() {
        return TopicBuilder.name("sendEmailTopic")
                .partitions(10)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic sendInDBTopic(){
        return TopicBuilder.name("sendInDBTopic")
                .partitions(10)
                .replicas(1)
                .build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
