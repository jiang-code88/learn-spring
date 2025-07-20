package com.learn._03_anno._01_BeanDependencyLookupAndInject.bean;

public class Item {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", class=" + getClass().getName() + "@" + Integer.toHexString(hashCode()) +
                '}';
    }
}
