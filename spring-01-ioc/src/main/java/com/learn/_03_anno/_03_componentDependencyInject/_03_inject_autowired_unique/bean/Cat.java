package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cat1")
@Primary
public class Cat {
    private String name = "cat1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
