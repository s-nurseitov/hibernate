package org.it.step;

import org.it.step.dao.UserDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.time.LocalDateTime;

public class DbConnectionClass {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");

        UserDAO dao = context.getBean("hibernateDao", UserDAO.class);

        dao.findAll().forEach(System.out::println);

        System.out.println("Try to find user by id = 1");
        System.out.println(dao.findOne(1L));

        User user = new User();
        user.setId(3);
        user.setLoggedAt(Timestamp.valueOf(LocalDateTime.now()));
        user.setLogin("Hibernate");
//        System.out.println(dao.createUser(user));
//        user.setLogin("Hiber");
//        System.out.println(dao.updateUser(user));
    }
}
