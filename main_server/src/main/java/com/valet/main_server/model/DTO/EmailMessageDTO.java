package com.valet.main_server.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmailMessageDTO {
    private String fromUser;
    private String toUser;
    private String value;
}
