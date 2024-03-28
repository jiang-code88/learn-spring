package com.learn.service;

import com.learn.dao.UserDao;
import com.learn.emtity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findById(String id) {
        return userDao.findById(id);
    }
}