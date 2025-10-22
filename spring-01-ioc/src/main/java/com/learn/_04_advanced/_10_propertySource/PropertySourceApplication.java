package com.learn._04_advanced._10_propertySource;

import com.learn._04_advanced._10_propertySource.bean.JdbcProperties;
import com.learn._04_advanced._10_propertySource.bean.JdbcYmlProperties;
import com.learn._04_advanced._10_propertySource.config.JdbcPropertiesConfiguration;
import com.learn._04_advanced._10_propertySource.config.JdbcYmlPropertiesConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @PropertySource 注解加载外部文件
 *  - 常用于加载应用的配置文件（常用的配置文件格式为 .properties 文件）
 *  - @PropertySource 还可以用于引入 xml 格式的配置文件（但是要遵从很严格的格式约束，因此弃用）。
 *  - @PropertySource 底层默认使用 jdk 的 Properties 类，来解析 .properties 和 .xml 配置文件，
 *    解析文件的默认策略类为 DefaultPropertySourceFactory。
 *
 * 需求：
 * 使用 @PropertySource 注解实现读取 .yml 文件的配置项
 *  - 读取的 yaml 格式文件解析 Properties 并没有提供，所以需要引入第三方的解析组件 snake-yaml。
 *  1. 实现 PropertySourceFactory 接口，
 *     定义读取 yaml 文件并转化为 Properties 对象的策略类。
 *  2. 使用 @PropertySource 注解读取 .yml 文件时，
 *     指定自定义的策略类替换默认策略类 DefaultPropertySourceFactory。
 *  3. 最后使用 @Value 注解指定配置项注入配置值。
 */
public class PropertySourceApplication {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(
                JdbcPropertiesConfiguration.class,
                JdbcYmlPropertiesConfiguration.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        // 使用 @PropertySource 注解实现读取 .properties 文件的配置项
        System.out.println("----------------------------");
        System.out.println(context.getBean(JdbcProperties.class));

        // 使用 @PropertySource 注解实现读取 .yml 文件的配置项
        System.out.println("----------------------------");
        System.out.println(context.getBean(JdbcYmlProperties.class));
    }
}
