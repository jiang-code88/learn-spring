package com.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 父容器的配置类, 仅存放 service 和 dao 的 bean
 */
@Configuration
// 排除扫描 @Controller 和 @Configuration(防止加载子容器配置类中的bean) 的 bean
@ComponentScan(value = "com.learn",
               excludeFilters = {
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
                    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
               }
)
public class RootConfiguration {
}
