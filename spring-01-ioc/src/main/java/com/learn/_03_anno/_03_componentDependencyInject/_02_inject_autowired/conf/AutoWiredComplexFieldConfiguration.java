package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.conf;

import com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean.Fish;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.complexBean")
public class AutoWiredComplexFieldConfiguration {
    @Bean
    public Fish fishPondFish1(){
        Fish fish = new Fish();
        fish.setName("fishPondFish1");
        return fish;
    }

    @Bean
    public Fish fishPondFish2(){
        Fish fish = new Fish();
        fish.setName("fishPondFish2");
        return fish;
    }

    @Bean
    public Fish fishPondFish3(){
        Fish fish = new Fish();
        fish.setName("fishPondFish3");
        return fish;
    }
}
