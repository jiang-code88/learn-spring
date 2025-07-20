package com.learn._04_advanced._04_bean_lifecycle;

import com.learn._04_advanced._04_bean_lifecycle.conf.InterfaceInitDestroyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 生命周期中的「初始化和销毁阶段」，通过回调执行自定义操作。
 * 通过实现 InitializingBean, DisposableBean 接口的方法,
 * 指定创建的 bean 初始化和销毁时的回调方法
 *
 * - pig1 实例通过 @Component + InitializingBean 接口 + DisposableBean 接口可以实现
 * - pig2 实例通过 @Bean + InitializingBean 接口 + DisposableBean 接口 也可以实现（不用 @Component 都可以）
 * - pig1 和 pig2 共存时，pig1 执行优先级高于 pig2
 */
public class InterfaceInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        // IOC 容器中将创建并放入 Pig 类型的 bean
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InterfaceInitDestroyConfiguration.class);
        System.out.println("<<<< 初始化 IOC 容器完成");

        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        context.close();
        System.out.println("<<<< 销毁 IOC 容器完成");
    }
}
