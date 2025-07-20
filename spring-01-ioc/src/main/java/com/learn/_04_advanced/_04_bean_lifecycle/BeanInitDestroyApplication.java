package com.learn._04_advanced._04_bean_lifecycle;

import com.learn._04_advanced._04_bean_lifecycle.conf.BeanInitDestroyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 框架可以在「初始化阶段和销毁阶段」通过回调机制执行一些我们自定义的操作，干预对象的生命周期过程。
 * - 在 bean 生命周期中的「初始化和销毁阶段」，通过回调执行自定义操作。
 * - 通过 @Bean 的 initMethod 和 destroyMethod 属性配置指定回调函数。
 *   - 初始化回调函数，是在 bean 被实例化再执行 setter 方法注入属性后才回调执行。
 *   - 销毁回调函数，是在 bean 被销毁回收前调用。
 */
public class BeanInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        // IOC 容器中将创建并放入 Cat 类型的 bean
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                        BeanInitDestroyConfiguration.class);
        System.out.println("<<<< 初始化 IOC 容器完成");

        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        // 容器销毁, IOC 容器中单实例的 bean 将被销毁
        context.close();
        System.out.println("<<<< 销毁 IOC 容器完成");
    }
}
