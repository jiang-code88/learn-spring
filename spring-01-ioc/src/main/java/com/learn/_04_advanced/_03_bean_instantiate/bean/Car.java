package com.learn._04_advanced._03_bean_instantiate.bean;

public class Car {
    private String name;

    public Car() {
        System.out.println("Car Constructor run ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", class=" + super.toString() +
                "}";
    }
}
