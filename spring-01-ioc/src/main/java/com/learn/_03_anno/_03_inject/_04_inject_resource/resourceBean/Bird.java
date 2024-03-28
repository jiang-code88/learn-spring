package com.learn._03_anno._03_inject._04_inject_resource.resourceBean;

import org.springframework.stereotype.Component;

@Component()
public class Bird {

    private String name = "bird";

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                '}';
    }
}
