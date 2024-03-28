package com.learn._03_anno._03_inject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解标记在类成员变量上实现依赖自动注入
 */
@Component
public class ZooField {

    @Value("happyZooField")
    private String name;

    // IOC 容器会按照属性对应的类型，
    // 从容器中找对应类型的 bean 赋值到该属性上，实现自动注入
    @Autowired
    private Dog dog;

    @Override
    public String toString() {
        return "ZooField{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
