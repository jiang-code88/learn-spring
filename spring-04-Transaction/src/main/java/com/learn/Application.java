package com.learn;

import com.learn.conf.TransactionConfiguration;
import com.learn.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 编程式事务：引入 DataSourceTransactionManager 和 TransactionTemplate 组件实现。
 * 声明时事务：@EnableTransactionManagement 模块装配注解 + @Transactional 注解。
 *
 * Spring 事务隔离级别：
 * Spring 事务传播行为：
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(TransactionConfiguration.class);
        UserInfoService userInfoService = context.getBean(UserInfoService.class);

        // 编程式事务
        userInfoService.ProgrammaticTransactionSaveAndQuery();

        // 声明式(注解式)事务
        userInfoService.DeclarativeTransactionSaveAndQuery();
    }
}
