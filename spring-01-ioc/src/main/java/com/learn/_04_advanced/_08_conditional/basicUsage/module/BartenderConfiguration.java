package com.learn._04_advanced._08_conditional.basicUsage.module;

import com.learn._04_advanced._08_conditional.basicUsage.bean.Bartender;
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
    public Bartender bartenderJohn(){
        return new Bartender("bartender-john");
    }

    @Bean
    public Bartender bartenderPaul(){
        return new Bartender("bartender-paul");
    }
}
