package com.learn._04_advanced._06_enableModule.module.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bartender 的配置类
 *  - 配置类中创建的多个 Bartender 实例，会被导入 IOC 容器
 *  - 配置类也会被创建 bean 放入容器
 */
@Configuration()
public class BartenderConfiguration {

    @Bean
    public Bartender bartenderConfigurationJohn(){
        return new Bartender("bartenderCon-john");
    }

    @Bean
    public Bartender bartenderConfigurationPaul(){
        return new Bartender("bartender-paul");
    }
}
