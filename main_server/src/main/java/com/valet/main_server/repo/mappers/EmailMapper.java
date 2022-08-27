package com.valet.main_server.repo.mappers;

import com.valet.main_server.model.EmailMessage;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmailMapper implements RowMapper<EmailMessage> {
    @Override
    public EmailMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EmailMessage.builder()
                .username(rs.getString("username"))
                .fromUserName(rs.getString("fromUserName"))
                .value(rs.getString("value"))
                .build();
    }
}
