package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Primary + @Component 注解或 @Bean 注解
 * 用于指定某个 bean 是会被优先自动注入的。
 */
@Component("fish1")
@Primary
public class Fish {
    private String name = "fish1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                '}';
    }
}
