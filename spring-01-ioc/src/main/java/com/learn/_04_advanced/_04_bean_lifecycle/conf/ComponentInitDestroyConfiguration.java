package com.learn._04_advanced._04_bean_lifecycle.conf;

import com.learn._04_advanced._04_bean_lifecycle.bean.componentBean.Pen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._04_advanced._04_bean_lifecycle.bean.componentBean")
public class ComponentInitDestroyConfiguration {
    @Bean
    public Pen Pen2(){
        Pen pen = new Pen();
        pen.setName("@Bean + @PostConstruct + @PreDestroy : pen2");
        return pen;
    }
}
