package com.learn._04_advanced._11_BeanPostProcessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 定义 Bean 的后置处理器处理逻辑
 * 1. 实现 BeanPostProcessor 接口。
 * 2. 实现方法参数中传入的 bean 就是被容器实例化好的 bean。
 * 3. 实现方法中可以针对实际的 bean 定义操作，然后返回 bean 给回容器中。
 */
public class AnimalBeanPostProcessor implements BeanPostProcessor {

    // 在 bean 初始化前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("postProcessBeforeInitialization...");
        return bean;
    }

    // 在 bean 初始化后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("postProcessAfterInitialization...");
        return bean;
    }
}
