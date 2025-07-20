package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解标记在 setter 方法上实现依赖自动注入
 */
@Component
public class DogSetterInject {

    @Value("helloDogSetterInject")
    private String name;
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    // 通过 setter 方法注入
    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "ZooSetter{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
