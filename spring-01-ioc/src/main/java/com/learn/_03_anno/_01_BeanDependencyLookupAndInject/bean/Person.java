package com.learn._03_anno._01_BeanDependencyLookupAndInject.bean;

public class Person {
    private String name;
    private int age;
    private Item item;

    public Person() {
    }

    public Person(String name, int age, Item item) {
        this.name = name;
        this.age = age;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", item=" + item +
                ", class=" + getClass().getName() + "@" + Integer.toHexString(hashCode()) +
                '}';
    }
}
