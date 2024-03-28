package com.learn._04_advanced._11_BeanPostProcessor.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cat implements InitializingBean {

    private String name;

    public Cat() {
        System.out.println("Constructor...");
    }

    public void initMethod(){
        System.out.println("initMethod...");
    }

    @PostConstruct
    public void PostConstruct(){
        System.out.println("postConstruct...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void setName(String name) {
        System.out.println("setter...");
        this.name = name;
    }
}
