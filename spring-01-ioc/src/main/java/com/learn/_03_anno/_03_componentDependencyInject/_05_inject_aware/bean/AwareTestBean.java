package com.learn._03_anno._03_componentDependencyInject._05_inject_aware.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.NamedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component()
public class AwareTestBean implements ApplicationContextAware, BeanNameAware, NamedBean {
    // 当这个 AwareTestBean 被初始化好后, 这两个成员变量将被容器回调注入
    private ApplicationContext applicationContext;
    private String beanName;

    // 实现 ApplicationContextAware 接口的 setApplicationContext() 方法, IOC 容器将会调用该方法
    // 通过回调方式从参数传递当前 IOC 容器 ApplicationContext 类型的 bean 给当前 bean
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // 利用注入的 ApplicationContext 类型 bean, 可以进一步做一些操作
    // 例如：打印容器中所有的 bean 的 beanName
    public void printBeanNames(){
        Stream.of(this.applicationContext.getBeanDefinitionNames())
                .forEach(System.out::println);
    }

    // 实现 BeanNameAware 接口的 SetBeanName() 方法, IOC 容器就会调用该方法
    // 通过回调的方式从参数传递该 bean 的 beanName 给 bean 自己
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    // 实现 NamedBean 接口的 getBeanName 方法, 通过该方法向外提供 beanName
    @Override
    public String getBeanName() {
        return beanName;
    }

    @Override
    public String toString() {
        return "AwareTestBean{" +
                "\napplicationContext=" + applicationContext +
                ", \nbeanName='" + beanName + '\'' +
                '}';
    }
}
