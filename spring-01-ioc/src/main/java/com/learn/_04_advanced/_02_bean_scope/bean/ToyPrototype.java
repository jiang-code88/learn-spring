package com.learn._04_advanced._02_bean_scope.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Bean 的作用域: prototype 原型 Bean
 *  - 每次对原型 Bean 提出请求时，都会创建的新的 Bean 实例
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 设置作用域为原型
public class ToyPrototype {
    public ToyPrototype() {
        System.out.println("实例化一个 ToyPrototype 类型的 bean");
    }
}
