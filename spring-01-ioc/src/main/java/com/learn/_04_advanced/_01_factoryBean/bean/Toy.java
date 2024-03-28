package com.learn._04_advanced._01_factoryBean.bean;

public abstract class Toy {
    private String name;

    public Toy(String name) {
        System.out.println("ToyFactoryBean 创建 Toy 类型的 bean");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", class=" + super.toString() +
                '}';
    }
}
