package com.learn._03_anno.issue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 场景：
 *  1. 使用 @Component 创建一个 Person 类型且名为 master 的 bean，
 *     并使用 @Value 注入 name 属性一个值 "paul"。
 *  2. 在配置类 PersonConfiguration 中使用 @Bean 注解同样创建
 *     一个 Person 类型且名为 administrator 的 bean，
 *     使用 setter 方法注入 name 属性为 "john"
 *  3. 启动容器获取 master 和 administrator 的 bean，发现 @Value 注解给
 *     administrator 这个 bean 的 name 属性也注入了值 "paul"，这不符合预期。
 *
 * 问题分析：
 *  1. 当 @Value 和 @Bean 在不同文件下时，@Bean 比 @Value 先执行，
 *     那么 @Bean 注解注入 name 属性的 "john" 就失效了，被 @Value 覆盖了
 *  2. 如果在同一文件下，@Value 比 @Bean 先执行，就不会有问题。
 * 解决方案：
 *  1. 避免使用 @Value 和 @Bean 在不同文件中同时去使用。
 *  2. 规避方式参考 YPerson 在 IssueConfiguration 中创建的两个 bean y1 和 y2。
 */
public class IssueApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(IssueConfiguration.class);
        Person master = context.getBean("master", Person.class);
        System.out.println(master);
        Person administrator = context.getBean("administrator", Person.class);
        System.out.println(administrator);

        System.out.println();

        YPerson y1 = context.getBean("y1", YPerson.class);
        System.out.println(y1);
        YPerson y2 = context.getBean("y2", YPerson.class);
        System.out.println(y2);
    }
}
