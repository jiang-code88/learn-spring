package com.learn._04_advanced._11_BeanPostProcessor.bean;

public class Ball {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name='" + name + '\'' +
                '}';
    }
}
