package com.learn._04_AOP_anno.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * IOC 容器配置类
 */
@Configuration
@ComponentScan({"com.learn._04_AOP_anno.service", "com.learn._04_AOP_anno.aop"})
@EnableAspectJAutoProxy // 在配置类中开启注解式 AOP
public class AspectJAOPConfiguration {
}