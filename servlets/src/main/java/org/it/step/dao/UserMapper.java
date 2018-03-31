package org.it.step.dao;

import org.it.step.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("user"));
        user.setLoggedAt(resultSet.getTimestamp("logged"));
        user.setId(resultSet.getLong("id"));
        return user;
    }
}
