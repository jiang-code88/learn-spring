package com.learn._04_advanced._02_bean_scope;

import com.learn._04_advanced._02_bean_scope.bean.Child;
import com.learn._04_advanced._02_bean_scope.conf.BeanScopeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Ioc 容器中作用域为单例和原型的 bean 的使用：
 *  - 单实例 bean：从一个 IOC 容器中只能获取到同一个 bean
 *  - 原型 bean：每次获取都是重新创建的 bean
 */
public class BeanScopeApplication {
    public static void main(String[] args) {
        // 初始化 IOC 容器, 容器中创建两个 Child 类型的 bean
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BeanScopeConfiguration.class);
        System.out.println("IOC 容器初始化完成");

        // 两个 bean 中均注入作用范围为单实例 singleton 和 原型 prototype 的 bean
        // 单实例 bean：从一个 IOC 容器中只能获取到同一个 bean
        // 原型 bean：每次获取都是重新创建的 bean
        context.getBeansOfType(Child.class).forEach((name, child)->{
            System.out.println(name + " : " + child);
        });
    }
}
