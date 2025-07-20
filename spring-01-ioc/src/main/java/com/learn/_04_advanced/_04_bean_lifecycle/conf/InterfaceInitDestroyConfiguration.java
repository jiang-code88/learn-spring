package com.learn._04_advanced._04_bean_lifecycle.conf;

import com.learn._04_advanced._04_bean_lifecycle.bean.interfaceBean.Pig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._04_advanced._04_bean_lifecycle.bean.interfaceBean")
public class InterfaceInitDestroyConfiguration {
    @Bean
    public Pig pig2(){
        Pig pig = new Pig();
        pig.setName("@Bean + InitializingBean 接口 + DisposableBean 接口 : pig2");
        return pig;
    }
}
