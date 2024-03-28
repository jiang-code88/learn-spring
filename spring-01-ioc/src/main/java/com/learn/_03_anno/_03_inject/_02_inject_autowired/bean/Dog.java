package com.learn._03_anno._03_inject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 等待被注入的 bean
 */
@Component
public class Dog {

    @Value("happy-dog")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                "class=" + getClass().getName() + "@"
                + Integer.toHexString(hashCode())+
                '}';
    }

}
