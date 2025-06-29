package com.learn.conf;

import com.learn.dao.UserInfoDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 1 进行 Mybatis 和 Spring 的整合
 * 2 引入编程式事务的 DataSourceTransactionManager 和 TransactionTemplate 组件
 * 3 启用注解式事务的 @EnableTransactionManagement 注解
 */
@Configuration
@ComponentScan("com.learn")
@EnableTransactionManagement
public class TransactionConfiguration {

    // 创建数据库连接信息对象
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://8.134.78.37:3306/mybatis?userSSL=false");
        dataSource.setUsername("mybatis");
        dataSource.setPassword("123456");
        return dataSource;
    }

    // 创建 SqlSessionFactory 对象到容器中
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    // 创建 SqlSession 对象到容器中
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    // 获取具体接口的 Mapper 代理对象
    @Bean
    public MapperFactoryBean<UserInfoDao> userDaoMapperFactoryBean(SqlSessionFactory sqlSessionFactory){
        MapperFactoryBean<UserInfoDao> userDaoMapperFactoryBean = new MapperFactoryBean<>();
        userDaoMapperFactoryBean.setMapperInterface(UserInfoDao.class);
        userDaoMapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
        return userDaoMapperFactoryBean;
    }

    // 包扫描获取接口的 Mapper 代理对象
    /* @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.learn.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return mapperScannerConfigurer;
    } */


    // 创建事务管理器，负责控制事务
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    // 创建事务模版，负责编程式事务（基于事务管理器创建）
    @Bean
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager dataSourceTransactionManager){
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(dataSourceTransactionManager);
        return transactionTemplate;
    }


}
