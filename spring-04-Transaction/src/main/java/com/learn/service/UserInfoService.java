package com.learn.service;

import com.learn.dao.UserInfoDao;
import com.learn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    /**
     * 使用编程式事务完成「插入并查询」操作
     */
    public void ProgrammaticTransactionSaveAndQuery(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        user.setGender("女");
        user.setAddr("ccc");

        // 使用事务模版创建事务
        //  - 事务中出现异常时，自动回滚事务操作
        transactionTemplate.execute((status)->{
            userInfoDao.save(user);

            int i = 1 / 0; // 模拟事务中出现异常

            List<User> users = userInfoDao.selectAll();
            users.forEach(System.out::println);

            return null; // 使用 TransactionCallbackWithoutResult 无需定义返回值
        });
    }

    /**
     * 使用声明式（@Transactional 注解式）事务完成「插入并查询」操作
     *  - @Transactional 只对 public 修饰的方法生效。
     *  - 如果标注在类上，表示这个类的所有 public 修饰的方法均实现事务控制。
     */
    @Transactional
    public void DeclarativeTransactionSaveAndQuery(){
        User user = new User();
        user.setUsername("ddd");
        user.setPassword("eee");
        user.setGender("男");
        user.setAddr("fff");

        userInfoDao.save(user);
        int i = 1 / 0; // 模拟事务中出现异常
        List<User> users = userInfoDao.selectAll();
        users.forEach(System.out::println);
    }




}
