package com.learn._03_anno._03_componentDependencyInject._04_inject_resource.conf;

import com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean")
public class ResourceInjectConfiguration {

    @Bean("bird2")
    public Bird bird(){
        Bird bird = new Bird();
        bird.setName("bird2");
        return bird;
    }

}
