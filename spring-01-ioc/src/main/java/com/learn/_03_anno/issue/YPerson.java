package com.learn._03_anno.issue;

public class YPerson {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "YPerson{" +
                "name='" + name + '\'' +
                '}';
    }
}
