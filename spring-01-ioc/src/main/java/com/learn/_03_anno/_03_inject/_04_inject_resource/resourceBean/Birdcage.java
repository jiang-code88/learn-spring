package com.learn._03_anno._03_inject._04_inject_resource.resourceBean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Birdcage {
    private String name = "birdcage";

    // @Resource 也是用来属性注入的注解，它与 @Autowired 的不同之处在于：
    // @Autowired 是首先按照类型注入，
    // @Resource 是首先按照属性名匹配 Bean 名称注入，找不到再用类型匹配注入
    @Resource
    private Bird bird;

    @Override
    public String toString() {
        return "Birdcage{" +
                "name='" + name + '\'' +
                ", bird=" + bird +
                '}';
    }
}
