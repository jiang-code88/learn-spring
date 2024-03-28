package com.learn._04_advanced._02_bean_scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC 容器创建完成后：
 *  - 作用域为 singleton 单实例的 bean 会被创建并放入容器中;
 *    一个 IOC 容器只有一个 bean, 每次访问都只可访问到这一个 bean
 *  - 作用域为 prototype 原型的 bean 不会被创建;
 *    要等到实际获取这个类型的 bean 时才创建, 每次访问获取的都是新的不同的 bean
 */
public class PrototypeBeanCreateTimeApplication {
    public static void main(String[] args) {
        // 初始化 IOC 容器, 扫描 bean 包下标记 @Component 的类时
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._04_advance._02_beanScope.bean");
        System.out.println("IOC 容器初始化完成");

        // 只会显示调用了 ToySingleton 类的构造方法, 实例化作用范围为单实例的 bean
        // 不会显示调用了 ToyPrototype 类的构造方法, 作用范围为原型的 bean 要等到实际获取时才会调用
    }
}
