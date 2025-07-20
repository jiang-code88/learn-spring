package com.learn._04_advanced._04_bean_lifecycle.bean.interfaceBean;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("pig1")
public class Pig implements InitializingBean, DisposableBean {
    private String name = "@Component + InitializingBean 接口 + DisposableBean 接口 : pig1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 实现 InitializingBean 中的 afterPropertiesSet() 方法,
    // 将在 bean 初始化后调用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " 被初始化了...");

    }

    // 实现 DisposableBean 中的 destroy() 方法,
    // 将在 bean 销毁时调用
    @Override
    public void destroy() throws Exception {
        System.out.println(name + " 被销毁了...");
    }
}
