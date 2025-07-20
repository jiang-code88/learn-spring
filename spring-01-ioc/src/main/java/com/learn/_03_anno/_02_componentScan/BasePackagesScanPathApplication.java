package com.learn._03_anno._02_componentScan;

import com.learn._03_anno._02_componentScan.bean.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 组件注册与扫描（直接指定包扫描路径启动容器）：
 * 1. 容器创建时直接扫描 AnnotationConfigApplicationContext 类指定路径包
 *    及其子包下所有使用 @Component 注解标记的类, 创建其 bean 放入容器。
 * 2. 如果 IOC 容器需要实例化的对象数量庞大，每个对象都编写一个 @Bean + 返回对象方法的话
 *    工作量非常大，开发效率低，所以 spring 提供一系列模版注解，如 @Component、 @Controller
 *    、@Service 、@Repository 这些注解标记在类上后，被 IOC 容器扫描到将自动创建类的实例化对象放入 IOC 容器。
 */
public class BasePackagesScanPathApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "com.learn._03_anno._02_componentScan.bean");

        Info infoBean = context.getBean("infoBean", Info.class);
        System.out.println(infoBean);
        System.out.println();

        // IOC 容器中不存在 @Configuration 注解标记创建的配置类 bean
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
