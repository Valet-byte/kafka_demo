package com.valet.db_server.model;

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
}
