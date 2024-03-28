package com.learn._03_anno._02_component.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 扫描指定路径包及子包下的所有 @Component 组件
// 如果不指定路径，注解默认扫描本类所在包及子包下的所有 @Component 组件
@ComponentScan("com.learn._03_anno._02_component.bean")
public class ComponentScanConfiguration {
}
