package com.learn._04_advanced._04_bean_lifecycle.bean.multipleBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("multiple1")
public class Multiple implements InitializingBean, DisposableBean {

    private String name = "multiple1";

    public Multiple() {
        System.out.println("Multiple: 构造器被调用...");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(name + " : setter 方法被调用...");
    }

    public void open() {
        System.out.println(name + " initMethod 属性 - 初始化...");
    }

    public void close() {
        System.out.println(name + " destroyMethod 属性 - 销毁...");
    }

    @PostConstruct
    public void addInk() {
        System.out.println(name + " @PostConstruct 注解 - 初始化");
    }

    @PreDestroy
    public void outwellInk() {
        System.out.println(name + " @PreDestroy 注解 - 销毁...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " InitializingBean 接口 - 初始化...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(name + " DisposableBean 接口 - 销毁...");
    }
}
