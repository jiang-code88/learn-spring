package com.learn._04_advanced._10_propertySource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用 @PropertySource 注解实现读取 .properties 文件的配置项
 */
@Configuration
@ComponentScan("com.learn._04_advanced._10_propertySource.bean")
@PropertySource("classpath:_04_advance/_10_propertySource/jdbc.properties")
public class JdbcPropertiesConfiguration {
}
