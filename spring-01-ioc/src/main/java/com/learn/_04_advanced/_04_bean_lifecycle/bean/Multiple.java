package com.learn._04_advanced._04_bean_lifecycle.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Multiple implements InitializingBean, DisposableBean {

    private String name;

    public Multiple() {
        System.out.println("Multiple: 构造器被调用...");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name + " : setter 方法被调用...");
    }

    public void open() {
        System.out.println("initMethod - 初始化...");
    }

    public void close() {
        System.out.println("destroyMethod - 销毁...");
    }

    @PostConstruct
    public void addInk() {
        System.out.println("@PostConstruct - 初始化");
    }

    @PreDestroy
    public void outwellInk() {
        System.out.println("@PreDestroy - 销毁...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean - 初始化...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean - 销毁...");
    }
}
