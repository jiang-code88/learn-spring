package com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bird1")
public class Bird {
    private String name = "bird1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", class=" + getClass().getName() + "@" + Integer.toHexString(hashCode()) +
                '}';
    }
}
