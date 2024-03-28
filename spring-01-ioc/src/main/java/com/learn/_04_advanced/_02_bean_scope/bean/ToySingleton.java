package com.learn._04_advanced._02_bean_scope.bean;

import org.springframework.stereotype.Component;

/**
 * Bean 的作用域: 默认为 singleton 单实例 Bean
 *  - 一个 IOC 容器中只有一个该 bean, 全局每次访问的都是这个 bean
 */
@Component
public class ToySingleton {

    public ToySingleton() {
        System.out.println("实例化一个 ToySingleton 类型的 bean");
    }
}
