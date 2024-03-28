package com.learn._03_anno._03_inject._02_inject_autowired;

import com.learn._03_anno._03_inject._02_inject_autowired.bean.Dog;
import com.learn._03_anno._03_inject._02_inject_autowired.bean.ZooConstructor;
import com.learn._03_anno._03_inject._02_inject_autowired.bean.ZooField;
import com.learn._03_anno._03_inject._02_inject_autowired.bean.ZooNotNoFound;
import com.learn._03_anno._03_inject._02_inject_autowired.bean.ZooSetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Autowired 注解标记在
 *  - 成员变量
 *  - 构造方法
 *  - setter 方法
 * 上实现依赖的自动注入
 */
public class AutowiredApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.learn._03_anno._03_inject._02_inject_autowired.bean");

        // 容器中通过 @Component 注解创建一个 Dog 类型的 bean
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

        // @Autowired 注解标记类成员变量实现自动注入
        ZooField zooField = context.getBean("zooField", ZooField.class);
        System.out.println(zooField);

        // @Autowired 注解标记构造方法实现自动注入
        ZooConstructor zooConstructor = context.getBean("zooConstructor", ZooConstructor.class);
        System.out.println(zooConstructor);

        // @Autowired 注解标记 setter 方法实现自动注入
        ZooSetter zooSetter = context.getBean("zooSetter", ZooSetter.class);
        System.out.println(zooSetter);
        // 以上注入的都是同一个 Dog 类型的 bean

        // 使用 @Autowired(required = false) 指定自动注入容器中不存在的 TmpDog 类型 bean 时, 不会报错找不到 bean
        ZooNotNoFound zooNotNoFound = context.getBean("zooNotNoFound", ZooNotNoFound.class);
        System.out.println(zooNotNoFound);
    }
}
