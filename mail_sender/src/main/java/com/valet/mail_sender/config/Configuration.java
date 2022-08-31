package com.valet.mail_sender.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.converter.BytesJsonMessageConverter;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public NewTopic emailTopic() {
        return TopicBuilder.name("sendEmailTopic")
                .partitions(10)
                .replicas(3)
                .build();
    }

    @Bean
    public BytesJsonMessageConverter bytesJsonMessageConverter(){
        return new BytesJsonMessageConverter();
    }
}
