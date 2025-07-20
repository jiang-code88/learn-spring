package com.learn._03_anno._03_componentDependencyInject._01_inject_by_value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 1. 使用 @PropertySource 注解指定要读取的外部 properties 配置文件路径。
 * 2. 使用 @Value 注解 + ${} 占位符，注入指定配置项的值。
 */
@Component
// @PropertySource 也可以标记在 @Configuration 标记的配置类上使用
@PropertySource("classpath:_03_anno/_03_inject_value/red.properties")
public class Red {
    @Value("${red.name}") // 使用 ${} 占位符表示要注入的配置项
    private String name;
    @Value("${red.order}")
    private int order;
    // ${red.defValue:def} 表示如果在 red.properties 配置文件找不到
    // red.defValue 配置项时, 使用 : 后面指定的默认值 "def"
    @Value("${red.defaultValue:def}")
    private String defaultValue;

    @Override
    public String toString() {
        return "Red{" +
                "name='" + name + '\'' +
                ", order=" + order +
                ", defaultValue=" + defaultValue +
                '}';
    }
}
