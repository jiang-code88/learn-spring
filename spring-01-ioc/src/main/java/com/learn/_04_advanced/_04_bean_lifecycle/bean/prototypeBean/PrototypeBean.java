package com.learn._04_advanced._04_bean_lifecycle.bean.prototypeBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeBean implements InitializingBean, DisposableBean {
    private String name;

    public PrototypeBean() {
        System.out.println("PrototypeBean: 构造器被调用...");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name + " : setter 方法被调用...");
    }

    public void open() {
        System.out.println("init-method 属性 - 初始化...");
    }

    public void close() {
        System.out.println("destroy-method 属性 - 销毁...");
    }

    @PostConstruct
    public void addInk() {
        System.out.println("@PostConstruct 注解 - 初始化");
    }

    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy 注解 - 销毁...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 接口 - 初始化...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 接口 - 销毁...");
    }
}
