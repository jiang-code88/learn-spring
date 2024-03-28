package com.learn.dao;

import com.learn.emtity.Department;
import com.learn.emtity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDao {

    public int update(User user) {
        System.out.println("update user: " + user);
        return 1;
    }

    public List<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("01", "jack",
                "findAllUsers", new Date(),null,
                new Department("01", "IT", "95563")));
        users.add(new User("02", "james",
                "findAllUsers", new Date(),null,
                new Department("01", "IT", "95563")));
        return users;
    }

    public User findById(String id) {
        System.out.println("find by id: " + id);
        return new User("02", "james",
                "findById", new Date(),null,
                new Department("01", "IT", "95563"));
    }

}