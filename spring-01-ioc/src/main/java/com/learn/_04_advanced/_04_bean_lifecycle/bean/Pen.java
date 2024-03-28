package com.learn._04_advanced._04_bean_lifecycle.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pen {
    private int ink;

    // 方法访问限制是 private 还是 public 并不影响
    @PostConstruct
    public void addInk(){
        this.ink = 100;
        System.out.println("钢笔中已加满墨水...");
    }

    @PreDestroy
    private void outwellInk(){
        this.ink = 0;
        System.out.println("钢笔中的墨水都放干净了...");
    }

    @Override
    public String toString() {
        return "Pen{" +
                "ink=" + ink +
                '}';
    }
}
