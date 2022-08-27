package com.valet.db_server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private Role role;
    private String password;
    private String email;
}
