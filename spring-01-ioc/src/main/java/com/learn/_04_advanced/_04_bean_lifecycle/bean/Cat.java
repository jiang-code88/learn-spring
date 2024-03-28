package com.learn._04_advanced._04_bean_lifecycle.bean;

public class Cat {
    private String name;

    public Cat() {
        System.out.println("cat 构造方法被调用...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(name + " setter 方法被调用...");
        this.name = name;
    }

    // Bean 初始化时的回调方法
    // 将在构造器创建 bean 实例和 setter 方法注入属性后才调用
    private void init(){
        System.out.println(name + " 被初始化了...");
    }

    // Bean 销毁的回调方法
    // 将在 bean 被销毁回收前调用，方法访问限制是 private 还是 public 经尝试发现并不影响
    private void destroy(){
        System.out.println(name + " 被销毁了...");
    }
}
