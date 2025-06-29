package com.learn.dao;

import com.learn.model.User;
import java.util.List;

public interface UserInfoDao {
    List<User> selectAll();

    void save(User user);
}
