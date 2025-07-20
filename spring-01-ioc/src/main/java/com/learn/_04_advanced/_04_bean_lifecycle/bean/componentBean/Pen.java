package com.learn._04_advanced._04_bean_lifecycle.bean.componentBean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("pen1")
public class Pen {
    private String name = "@Component + @PostConstruct + @PreDestroy : pen1";

    // 方法访问限制是 private 还是 public 并不影响
    @PostConstruct
    public void addInk(){
        System.out.println(name + " 钢笔中已加满墨水...");
    }

    @PreDestroy
    private void outwellInk(){
        System.out.println(name + " 钢笔中的墨水都放干净了...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", class=" + super.toString() +
                '}';
    }
}
