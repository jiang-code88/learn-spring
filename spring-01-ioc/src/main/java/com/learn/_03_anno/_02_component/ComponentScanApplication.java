package com.learn._03_anno._02_component;

import com.learn._03_anno._02_component.bean.Info;
import com.learn._03_anno._02_component.conf.ComponentScanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 使用 @Component 注解简化逐个使用 @Bean 或 xml 的 <bean> 标签创建 bean
 *
 * 1. 创建容器并读取 @Configuration 配置类中的内容。
 * 2. 配置类中使用 @ComponentScan 注解指定包路径，容器创建时将扫描指定路径包及其子包下
 *    所有 @Component 注解标记的类, 创建其 bean 放入容器中。
 * 3. 也可以在 AnnotationConfigApplicationContext 中直接指定包路径来扫描创建 bean。
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

        // 存在通过 @Configuration 注解标记创建的配置类 bean
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
