package com.learn._03_anno._01_BeanDependencyLookupAndInject;

import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Item;
import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Person;
import com.learn._03_anno._01_BeanDependencyLookupAndInject.conf.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用注解创建 IOC 容器
 * 1. @Configuration 注解标记类代表配置类。
 * 2. 配置类中使用 @Bean 注解标记方法创建容器中的 bean。
 * 3. 使用 AnnotationConfigApplicationContext 创建注解驱动 IOC 容器
 * 4. 在配置类 @Bean 注解标记的创建 bean 方法中，可以实现 setter 和构造器依赖注入
 */
public class AnnoApplication {
    public static void main(String[] args) {
        // 创建驱动注解 IOC 容器
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BeanConfiguration.class);

        // 获取 Person.class 类型的四个 bean, 每个 bean 的名称不相同
        Person person = context.getBean("person", Person.class);
        System.out.println("person：" + person);

        Person personA = context.getBean("personA", Person.class);
        System.out.println("personA：" + personA);

        Person personB = context.getBean("personB", Person.class);
        System.out.println("personB：" + personB);

        Person personC = context.getBean("personC", Person.class);
        System.out.println("personC：" + personC);

        // 上述 bean 中注入的 Item 类型依赖，均为 xxitemxx 这个的 bean
        Item item = context.getBean("xxitemxx", Item.class);
        System.out.println("xxitemxx：" + item);
    }
}
