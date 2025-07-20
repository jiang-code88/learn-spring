package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoWiredUniqueByFieldName {
    @Value("helloAutoWiredUniqueByFieldName")
    private String name;

    // 如果 bean 的 beanName 和成员变量名相同直接注入
    @Autowired
    private Sheep whiteSheep;

    @Override
    public String toString() {
        return "ZooByName{" +
                "name='" + name + '\'' +
                ", sheep=" + whiteSheep +
                '}';
    }
}
