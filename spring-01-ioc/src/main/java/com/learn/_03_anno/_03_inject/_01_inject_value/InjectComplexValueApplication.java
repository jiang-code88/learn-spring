package com.learn._03_anno._03_inject._01_inject_value;

import com.learn._03_anno._03_inject._01_inject_value.complexBean.Complex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Component 注解创建 bean 的依赖注入
 *
 * 使用 @Value + SpEL 表达式注入复杂类型的成员变量值
 */
public class InjectComplexValueApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._03_anno._03_inject._01_inject_value.complexBean");

        Complex bean = context.getBean(Complex.class);
        System.out.println(bean);
    }
}
