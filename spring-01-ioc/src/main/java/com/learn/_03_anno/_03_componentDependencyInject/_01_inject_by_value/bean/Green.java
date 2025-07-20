package com.learn._03_anno._03_componentDependencyInject._01_inject_by_value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用 SpEL 表达式引用 IOC 容器中其它 Bean 的属性值
 */
@Component
public class Green {

    // 需求：直接复制 Blue 类型 bean 的 name 属性值
    // 内部实现：调用 Blue 类型 bean 的 getter 方法获取其成员变量 name 的值
    @Value("#{'ref of ' + blue.name}")
    private String name;

    // 需求：Green 类型 bean 的 order 属性值要比 Blue 类型 bean 的 order 属性值大 1
    @Value("#{blue.order + 1}")
    private int order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Green{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
