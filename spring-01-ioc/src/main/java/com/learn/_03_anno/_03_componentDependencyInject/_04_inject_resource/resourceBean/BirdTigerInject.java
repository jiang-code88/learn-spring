package com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BirdTigerInject {
    private String name = "resourceInjectBean";

    @Resource // 按成员变量类型匹配 bean 的类型注入
    private Tiger tiger;

    @Resource // 按成员变量名 bird1 匹配 bean 的 name 注入
    private Bird bird1;

    @Resource(name = "bird1") // 按指定名 bird2 匹配 bean 的 name 注入
    private Bird bird2;

    @Override
    public String toString() {
        return "ResourceInjectBean{" +
                "name='" + name + '\'' +
                ", tiger=" + tiger +
                ", bird1=" + bird1 +
                ", bird2=" + bird2 +
                '}';
    }
}
