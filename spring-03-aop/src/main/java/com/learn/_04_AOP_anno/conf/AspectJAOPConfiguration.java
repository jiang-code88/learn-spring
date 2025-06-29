package com.learn._04_AOP_anno.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * IOC 容器配置类
 */
@Configuration
@ComponentScan()
@EnableAspectJAutoProxy
public class AspectJAOPConfiguration {
}