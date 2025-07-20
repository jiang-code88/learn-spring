package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoWiredUniqueByPrimary {
    @Value("helloAutoWiredUniqueByPrimary")
    private String name;

    // 注入使用 @Primary 注解标记的首选注入 bean
    @Autowired
    private Fish fish;

    @Override
    public String toString() {
        return "ZooPrimary{" +
                "name='" + name + '\'' +
                ", fish=" + fish +
                '}';
    }
}
