package com.valet.main_server.repo;

import com.valet.main_server.model.EmailMessage;
import com.valet.main_server.repo.mappers.EmailMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EmailRepoImpl implements EmailRepo {

    private final NamedParameterJdbcTemplate jdbc;
    private final EmailMapper mapper;

    @Override
    public List<EmailMessage> getMyEmail(String username) {
        final MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name", username);

        return jdbc.query("SELECT emails.\"fromUserName\", emails.username, emails.value from emails WHERE username = :name", source, mapper);
    }
}
