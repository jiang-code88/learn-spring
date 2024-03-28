package com.learn._04_advanced._01_factoryBean.bean;

import org.springframework.beans.factory.FactoryBean;


public class ToyFactoryBean implements FactoryBean<Toy> {

    private Child child;

    public ToyFactoryBean() {
        System.out.println("IOC 容器实例化 ToyFactoryBean 类型的 bean");
    }

    @Override
    public Toy getObject() throws Exception {
        System.out.println("调用一次 FactoryBean 的 getObject() 方法");
        switch (child.getWantToy()){
            case "ball":
                return new Ball("ball");
            case "car":
                return new Car("car");
            default:
                return null;
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Toy.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "ToyFactoryBean{" +
                "child=" + child +
                ", class=" +super.toString() +
                '}';
    }
}
