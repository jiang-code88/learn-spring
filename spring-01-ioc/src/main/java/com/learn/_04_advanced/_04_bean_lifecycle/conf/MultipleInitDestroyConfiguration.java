package com.learn._04_advanced._04_bean_lifecycle.conf;

import com.learn._04_advanced._04_bean_lifecycle.bean.multipleBean.Multiple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._04_advanced._04_bean_lifecycle.bean.multipleBean")
public class MultipleInitDestroyConfiguration {
    @Bean(initMethod = "open", destroyMethod = "close")
    public Multiple multiple2(){
        Multiple multiple = new Multiple();
        multiple.setName("multiple2");
        return multiple;
    }
}
