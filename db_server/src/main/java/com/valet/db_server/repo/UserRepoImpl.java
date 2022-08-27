package com.valet.db_server.repo;

import com.valet.db_server.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepoImpl implements UserRepo {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public User registration(User user) {
        final MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name", user.getName());
        source.addValue("password", user.getPassword());
        source.addValue("email", user.getEmail());

        KeyHolder holder = new GeneratedKeyHolder();

        jdbc.update("INSERT into users (name, password, email) VALUES " +
                "(:name, :password, :email)", source, holder);

        user.setId((Long) holder.getKeys().get("id"));
        return user;
    }
}
