package org.it.step.dao;

import org.it.step.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeDao")
public class FakeUserDAO implements UserDAO {
    @Override
    public User findOne(long id) {
        System.out.println("Fake findOne");
        return null;
    }

    @Override
    public List<User> findAll() {
        System.out.println("Fake findAll");
        return null;
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
