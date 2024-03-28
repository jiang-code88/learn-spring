package com.learn._03_anno._03_inject._01_inject_value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用 @Value 注解注入字面量到成员变量中
 */
@Component
public class Black {
    @Value("black-value-anno")
    private String name;
    @Value("0")
    private int order;

    @Override
    public String toString() {
        return "Black{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
