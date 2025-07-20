package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解标记在构造方法上实现依赖自动注入
 *  - 在构造方法上即使不加 @Autowired 注解，都会自动实现加了的效果（相同类型依赖自动注入）
 */
@Component
public class DogConstructorInject {

    @Value("helloDogConstructorInject")
    private String name;
    private Dog dog;

    // 使用构造器注入
    // @Autowired
    public DogConstructorInject(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "DogConstructorInject{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
