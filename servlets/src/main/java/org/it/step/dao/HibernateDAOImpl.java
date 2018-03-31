package org.it.step.dao;

import org.it.step.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;
import java.util.List;

@Component("hibernateDao")
public class HibernateDAOImpl implements UserDAO {

    private EntityManager entityManager;
    @PostConstruct
    public void init(){
        entityManager = Persistence.createEntityManagerFactory("HelloWorldPU").createEntityManager();
    }

    @Override
    public User findOne(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public boolean createUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        entityManager.merge(user);
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        entityManager.remove(user);
        return true;
    }
}
