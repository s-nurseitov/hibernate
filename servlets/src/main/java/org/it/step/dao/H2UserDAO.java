package org.it.step.dao;

import org.it.step.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("h2dao")
public class H2UserDAO implements UserDAO {

    private static final String SELECT_USERS = "select id, user, logged from it_step.users";
    private static final String SELECT_ONE_USER = SELECT_USERS + " where id = :id";

    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public H2UserDAO(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public User findOne(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbcOperations.queryForObject(SELECT_ONE_USER, params, new UserMapper());
    }

    @Override
    public List<User> findAll() {
        return jdbcOperations.query(SELECT_USERS, new UserMapper());
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
