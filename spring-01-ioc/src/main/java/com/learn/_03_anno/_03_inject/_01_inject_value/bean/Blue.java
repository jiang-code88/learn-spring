package com.learn._03_anno._03_inject._01_inject_value.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 使用 SpEL 表达式注入字符串代表的字面量
 *  - SpEL 的语法统一用 #{} 表示，花括号内部编写表达式语言。
 *  - SpEL 表达值指定字符串时，需要额外在花括号内部加单引号。
 */
@Component
public class Blue {

    @Value("#{'blue-value-byspel'}")
    private String name;

    @Value("#{2}")
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
        return "Blue{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
