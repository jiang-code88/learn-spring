package com.learn._04_advanced._10_propertySource.config;

import com.learn._04_advanced._10_propertySource.factory.YmlPropertySourceFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource 注解默认的 DefaultPropertySourceFactory 解析策略无法解析 yaml 文件。
 * 所有需要引入 snakeyaml 组件并自定义解析策略类 YmlPropertySourceFactory，
 * 解析 yaml 文件为 Properties 对象给 @Value 注解使用。
 */
@Configuration
@ComponentScan("com.learn._04_advanced._10_propertySource.bean")
@PropertySource(value = "classpath:_04_advance/_10_propertySource/jdbc.yml",
        factory = YmlPropertySourceFactory.class)
public class JdbcYmlPropertiesConfiguration {
}

