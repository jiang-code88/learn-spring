package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean;

import org.springframework.stereotype.Component;

@Component("whiteSheep")
public class Sheep {
    private String name="whiteSheep";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "sheep{" +
                "name='" + name + '\'' +
                '}';
    }
}
