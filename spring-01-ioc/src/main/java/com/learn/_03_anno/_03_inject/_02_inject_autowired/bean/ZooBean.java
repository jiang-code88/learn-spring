package com.learn._03_anno._03_inject._02_inject_autowired.bean;

public class ZooBean {
    private String name;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "ZooBean{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
