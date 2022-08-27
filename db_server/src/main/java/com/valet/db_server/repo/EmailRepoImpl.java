package com.valet.db_server.repo;

import com.valet.db_server.model.EmailMessage;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class EmailRepoImpl implements EmailRepo {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public void save(EmailMessage message) {
        final MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("userName", message.getUsername());
        source.addValue("fromUser", message.getFromUserName());
        source.addValue("value", message.getValue());

        jdbc.update("INSERT into emails (\"fromUserName\", username, \"value\") " +
                "values (:fromUser, :userName, :value)", source);
    }
}
