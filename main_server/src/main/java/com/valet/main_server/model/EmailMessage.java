package com.valet.main_server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valet.main_server.model.DTO.EmailMessageDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmailMessage {
    private Long id;
    private String email;
    private String username;
    private String fromUserName;
    private EmailType emailType;
    private String value;

    @JsonIgnore
    public EmailMessageDTO toDTO(){
        return EmailMessageDTO.builder()
                .fromUser(this.fromUserName)
                .toUser(this.username)
                .value(this.value)
                .build();
    }
}
