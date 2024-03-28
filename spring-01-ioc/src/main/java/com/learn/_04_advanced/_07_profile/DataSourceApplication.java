package com.learn._04_advanced._07_profile;

import com.learn._04_advanced._07_profile.datasource.DataSource;
import com.learn._04_advanced._07_profile.datasource.DataSourceConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 条件注入 @profile 注解在实际开发中的用途：
 *
 * 需求：根据开发环境/测试环境/生产环境, 不同环境切换使用不同的具体数据源。
 *   - 将不同环境的表示和切换控制分离到外部配置文件 datasource.properties 中，
 *     通过修改配置项 spring.profiles.active 的值切换导入不同的数据源 bean。
 *   - 外部配置文件通过 @PropertySource 注解实现读取。
 *   - 更改配置值从而变换导入的依赖，通过内置的 spring.profiles.active 配置和 @Profile 注解实现。
 */
public class DataSourceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        DataSourceConfiguration.class);
        // 打印容器中具体数据源的 bean 信息
        Map<String, DataSource> beansOfType = context.getBeansOfType(DataSource.class);
        beansOfType.forEach((name,datasource)-> System.out.println(name + " : " + datasource));
    }
}
