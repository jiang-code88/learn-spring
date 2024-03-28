package com.learn._03_anno._02_component;

import com.learn._03_anno._02_component.bean.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 1. 容器创建时将直接扫描 AnnotationConfigApplicationContext
 *    指定路径包以及其子包下所有使用 @Component 注解标记的类, 创建其 bean 放入容器。
 */
public class BasePackagePathApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.learn._03_anno._02_component.bean");

        Info infoBean = context.getBean("infoBean", Info.class);
        System.out.println(infoBean);
        System.out.println();

        // 不存在通过 @Configuration 注解标记创建的配置类 bean
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
