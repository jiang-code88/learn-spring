package com.learn._03_anno._02_componentScan;

import com.learn._03_anno._02_componentScan.bean.Info;
import com.learn._03_anno._02_componentScan.conf.ComponentScanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 组件注册与扫描（配置类中配置包扫描路径启动容器）
 * 1. 创建容器并读取 @Configuration 配置类中的内容。
 * 2. 配置类中使用 @ComponentScan 注解指定包路径，容器创建时将扫描指定路径包及其子包下
 *    所有 @Component 注解标记的类, 创建其 bean 放入容器中。
 * 4. @Controller 、@Service 、@Repository 分别代表表现层、业务层、持久层。
 *    这三个注解的作用与 @Component 完全一致。
 */
public class ComponentScanApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ComponentScanConfiguration.class);

        Info infoBean = context.getBean("infoBean", Info.class);
        System.out.println(infoBean);
        System.out.println();

        // IOC 容器中存在 @Configuration 注解标记创建的配置类 bean
        // @Configuration 注解也是 @Component，所以配置类也会被包扫描注册实例对象到容器中。
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
