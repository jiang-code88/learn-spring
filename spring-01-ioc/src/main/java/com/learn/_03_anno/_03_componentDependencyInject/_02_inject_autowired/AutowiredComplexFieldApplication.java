package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired;

import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.complexBean.FishPond;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.conf.AutoWiredComplexFieldConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 ComplexFieldConfiguration 中定义了三个 Fish 类型的 bean
 * 在 FishPond 类型的 bean 中使用 @Autowired 自动注入这三个 bean 到
 * List<Fish> 类型的成员变量中
 */
public class AutowiredComplexFieldApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AutoWiredComplexFieldConfiguration.class);

        FishPond fishPond = context.getBean("fishPond", FishPond.class);
        System.out.println(fishPond);
    }
}
