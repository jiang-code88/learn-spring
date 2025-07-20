package com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean;

import org.springframework.stereotype.Component;

@Component("tiger1")
public class Tiger {
    private String name = "tiger1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", class=" + getClass().getName() + "@" + Integer.toHexString(hashCode()) +
                '}';
    }
}
