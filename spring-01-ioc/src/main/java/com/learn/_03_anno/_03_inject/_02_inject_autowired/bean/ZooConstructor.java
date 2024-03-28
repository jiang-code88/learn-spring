package com.learn._03_anno._03_inject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解标记在构造方法上实现依赖自动注入
 *  - 在构造方法上即使不使用 @Autowired 注解，都会指定自动注入依赖
 */
@Component
public class ZooConstructor {

    @Value("happyZooConstructor")
    private String name;
    private Dog dog;

    // 使用构造器注入
    // @Autowired
    public ZooConstructor(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "ZooConstructor{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
