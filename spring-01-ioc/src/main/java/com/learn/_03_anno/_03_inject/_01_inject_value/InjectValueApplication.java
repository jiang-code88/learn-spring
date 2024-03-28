package com.learn._03_anno._03_inject._01_inject_value;

import com.learn._03_anno._03_inject._01_inject_value.bean.Black;
import com.learn._03_anno._03_inject._01_inject_value.bean.Blue;
import com.learn._03_anno._03_inject._01_inject_value.bean.Green;
import com.learn._03_anno._03_inject._01_inject_value.bean.Red;
import com.learn._03_anno._03_inject._01_inject_value.bean.White;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Component 注解创建 bean 的依赖注入
 *
 * 方式一：使用 @Value 注解注入字符串表示的字面量
 * 方式二：使用 @Value 注解 + ${} 占位符，注入外部 properties 文件中指定的配置项值
 * 方式三：使用 @Value 注解 + SpEL 表达值注入字符串代表的字面量
 * 方式四：使用 @Value 注解 + SpEL 表达值注入引用 IOC 容器中其他 bean 的属性值
 * 方式五：使用 @Value 注解 + SpEL 表达式注入方法调用返回值或引用类的常量
 */
public class InjectValueApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "com.learn._03_anno._03_inject._01_inject_value.bean");
        // inject class Black bean field value by @Value + string
        Black black = context.getBean(Black.class);
        System.out.println(black);

        // inject class Red bean field value by @Value + properties file
        Red red = context.getBean("red", Red.class);
        System.out.println(red);

        // inject class Blue value by @Value + SpEL + String
        Blue blue = context.getBean("blue", Blue.class);
        System.out.println(blue);

        // SpEL 表达式可以取 IOC 容器中其它 bean 的属性值
        Green green = context.getBean("green", Green.class);
        System.out.println(green);

        // SpEL 表达式不仅可以引用对象的属性，还可以直接引用类常量，以及调用对象的方法等
        White white = context.getBean("white", White.class);
        System.out.println(white);
    }
}
