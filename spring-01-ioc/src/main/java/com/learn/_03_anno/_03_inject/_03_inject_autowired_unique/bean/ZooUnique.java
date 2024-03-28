package com.learn._03_anno._03_inject._03_inject_autowired_unique.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired + @Qualifier 注解
 * 通过指定 beanName 自动注入相同类型 bean 中的某个
 */
@Component
public class ZooUnique {
    @Value("happyZooUnique")
    private String name;

    @Autowired
    @Qualifier("cat2") // 显示指定自动注入 bean 的 beanName
    private Cat cat;

    @Override
    public String toString() {
        return "ZooUnique{" +
                "name='" + name + '\'' +
                ", cat=" + cat +
                '}';
    }
}
