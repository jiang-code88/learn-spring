package com.learn._03_anno._03_inject._03_inject_autowired_unique.conf;

import com.learn._03_anno._03_inject._03_inject_autowired_unique.bean.Cat;
import com.learn._03_anno._03_inject._03_inject_autowired_unique.bean.Fish;
import com.learn._03_anno._03_inject._03_inject_autowired_unique.bean.Sheep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.learn._03_anno._03_inject._03_inject_autowired_unique.bean")
public class UniqueConfiguration {

    @Bean
    public Cat cat2(){
        Cat cat = new Cat();
        cat.setName("cat2");
        return cat;
    }

    @Bean
    public Fish fish2(){
        Fish fish = new Fish();
        fish.setName("fish2");
        return fish;
    }

    @Bean
    public Sheep blackSheep(){
        Sheep sheep = new Sheep();
        sheep.setName("blackSheep");
        return sheep;
    }
}
