package com.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IOC 容器的配置类
 */
@Configuration
public class UserConfiguration {
    @Bean
    public UserService userService(){
        return new UserService();
    }
}
