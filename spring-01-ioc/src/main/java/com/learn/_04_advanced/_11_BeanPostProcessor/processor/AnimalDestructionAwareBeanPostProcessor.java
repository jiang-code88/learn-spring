package com.learn._04_advanced._11_BeanPostProcessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * 定义 Bean 的实例摧毁阶段拦截，后置处理器处理逻辑
 */
public class AnimalDestructionAwareBeanPostProcessor
        implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName)
            throws BeansException {
        System.out.println("postProcessBeforeDestruction...");
    }
}
