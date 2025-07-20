package com.learn._03_anno._02_componentScan.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* 如果 @ComponentScan 注解没有指定路径，默认扫描本类所在包及子包下的所有 @Component 组件 */
// @ComponentScan()

/* 扫描 @ComponentScan 注解指定路径包及其子包下的所有 @Component 组件 */
@ComponentScan("com.learn._03_anno._02_componentScan.bean")

@Configuration
public class ComponentScanConfiguration {
}
