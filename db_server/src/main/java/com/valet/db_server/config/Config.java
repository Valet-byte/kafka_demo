package com.valet.db_server.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.BytesJsonMessageConverter;

@Configuration
public class Config {
    @Bean
    public BytesJsonMessageConverter bytesJsonMessageConverter(){
        return new BytesJsonMessageConverter();
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
}
