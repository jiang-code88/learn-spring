package com.learn._04_advanced._11_BeanPostProcessor.bean;

import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PreDestroy;

public class Bird implements DisposableBean {
    private String name;

    public Bird() {
        System.out.println("Constructor...");
    }

    public void destroyMethod(){
        System.out.println("destroyMethod...");
    }

    @PreDestroy
    public void PreDestroy(){
        System.out.println("preDestroy...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    public void setName(String name) {
        System.out.println("setter...");
        this.name = name;
    }
}
