package com.learn._04_advanced._11_BeanPostProcessor.processor;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Ball;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 定义 Bean 的实例化阶段拦截，后置处理器的处理逻辑
 */
public class AnimalInstantiationAwareBeanPostProcessor
        implements InstantiationAwareBeanPostProcessor {

    // 在 bean 实例化前执行
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass,
                                                 String beanName) throws BeansException {
        // 拦截 beanName 为 "ball" 的 bean 的实例化，然后实例化一个新的 bean 替换掉
        if ("ball".equals(beanName)){
            // 返回非null，代表拦截创建
            Ball ball = new Ball();
            ball.setName("postProcessBeforeInstantiation");
            return ball;
        }
        // 默认直接返回null，代表不拦截
        return null;
    }

    // 在 bean 属性注入前执行
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs,
                                                Object bean,
                                                String beanName) throws BeansException {
        // 拦截 beanName 为 "ball2" 的 bean 的实例化，然后给他的 name 属性赋值 Timmy
        if ("ball2".equals(beanName)){
            MutablePropertyValues values = new MutablePropertyValues(pvs);
            values.addPropertyValue("name", "Timmy");
            return values;
        }
        return null;
    }

    // 该方法如果返回 false，则 postProcessProperties 方法就不会执行
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        // return false;
        return true;
    }
}
