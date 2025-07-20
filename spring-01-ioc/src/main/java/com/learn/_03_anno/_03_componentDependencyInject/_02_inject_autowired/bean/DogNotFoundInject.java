package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解的 required 属性控制自动注入的依赖是否必要，
 *  - true 依赖必要，依赖不存在时会报错提示。（默认为 true）
 *  - false 依赖非必要，依赖不存在时不会报错提示。
 */
@Component
public class DogNotFoundInject {

    @Value("helloDogNotFoundInject")
    private String name;

    @Autowired(required = false)
    private DogNotFound dogNotFound;

    @Override
    public String toString() {
        return "ZooNotNoFound{" +
                "name='" + name + '\'' +
                ", tmpDog=" + dogNotFound +
                '}';
    }
}
