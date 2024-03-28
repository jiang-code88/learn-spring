package com.learn._03_anno.issue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("master")
public class Person {

    @Value("paul")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
