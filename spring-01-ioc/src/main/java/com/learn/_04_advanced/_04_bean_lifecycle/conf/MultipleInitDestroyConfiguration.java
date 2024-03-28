package com.learn._04_advanced._04_bean_lifecycle.conf;

import com.learn._04_advanced._04_bean_lifecycle.bean.Multiple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipleInitDestroyConfiguration {
    @Bean(initMethod = "open", destroyMethod = "close")
    public Multiple multiple(){
        Multiple multiple = new Multiple();
        multiple.setName("multiple");
        return multiple;
    }
}
