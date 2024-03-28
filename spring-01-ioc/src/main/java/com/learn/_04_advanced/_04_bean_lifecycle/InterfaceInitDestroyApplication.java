package com.learn._04_advanced._04_bean_lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 生命周期中的「初始化和销毁阶段」，通过回调执行自定义操作。
 * 通过实现 InitializingBean, DisposableBean 接口的方法,
 * 指定创建的 bean 初始化和销毁时的回调方法
 */
public class InterfaceInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        // IOC 容器中将创建并放入 Pig 类型的 bean
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._04_advance._04_bean_lifecycle.bean.interfaceBean");
        System.out.println("<<<< 初始化 IOC 容器完成");

        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        context.close();
        System.out.println("<<<< 销毁 IOC 容器完成");
    }
}
