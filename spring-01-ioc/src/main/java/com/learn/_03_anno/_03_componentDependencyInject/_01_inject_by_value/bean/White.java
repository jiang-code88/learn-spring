package com.learn._03_anno._03_componentDependencyInject._01_inject_by_value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用 SpEL 表达式调用方法或直接引用类的属性
 */
@Component
public class White {

    // 需求：取 Green 类型 bean 的 name 属性值的前 15 个字符
    // 使用 SpEL 表达式调用方法
    @Value("#{notColorGreen.name.substring(0,15)}")
    private String name;

    // 需求：order 属性的值取 Integer 的最大值
    // 使用 SpEL 表达式引用类的全局常量
    // SpEL 表达式直接引用类的属性，需要在类的全限定名外面使用 T() 包围
    @Value("#{T(java.lang.Integer).MAX_VALUE}")
    private int order;

    @Override
    public String toString() {
        return "White{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
