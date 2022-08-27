package com.valet.main_server.repo;

import com.valet.main_server.model.User;
import com.valet.main_server.repo.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRepoImpl implements UserRepo {

    private final NamedParameterJdbcTemplate jdbc;
    private final UserMapper userMapper;

    @Override
    public User findByName(String username) {

        final MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name", username);


        return jdbc.queryForObject("SELECT * FROM users " +
                "JOIN roles r on r.id = users.role_id WHERE users.name = :name", source, userMapper);
    }
}
