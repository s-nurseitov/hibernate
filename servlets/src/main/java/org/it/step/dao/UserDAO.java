package org.it.step.dao;

import org.it.step.User;

import java.util.List;

public interface UserDAO {

    User findOne(long id);

    List<User> findAll();

    boolean createUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);
}
