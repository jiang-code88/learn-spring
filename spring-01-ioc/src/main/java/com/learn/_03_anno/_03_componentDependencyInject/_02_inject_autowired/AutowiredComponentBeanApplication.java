package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired;

import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.Dog;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogConstructorInject;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogFieldInject;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogNotFoundInject;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogSetterInject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Autowired 注解标记在
 *  - 成员变量
 *  - 构造方法
 *  - setter 方法
 * 上实现依赖的自动注入
 */
public class AutowiredComponentBeanApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                "com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean");

        // 容器中通过 @Component 注解创建一个 Dog 类型的 bean
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

        // @Autowired 注解标记类成员变量实现自动注入
        DogFieldInject dogFieldInject =
                context.getBean("dogFieldInject", DogFieldInject.class);
        System.out.println(dogFieldInject);

        // @Autowired 注解标记构造方法实现自动注入
        DogConstructorInject dogConstructorInject =
                context.getBean("dogConstructorInject", DogConstructorInject.class);
        System.out.println(dogConstructorInject);

        // @Autowired 注解标记 setter 方法实现自动注入
        DogSetterInject dogSetterInject =
                context.getBean("dogSetterInject", DogSetterInject.class);
        System.out.println(dogSetterInject);
        // 以上注入的都是同一个 Dog 类型的 bean

        // 使用 @Autowired(required = false) 指定自动注入容器中不存在的 TmpDog 类型 bean 时, 不会报错找不到 bean
        DogNotFoundInject dogNotFoundInject =
                context.getBean("dogNotFoundInject", DogNotFoundInject.class);
        System.out.println(dogNotFoundInject);
    }
}
