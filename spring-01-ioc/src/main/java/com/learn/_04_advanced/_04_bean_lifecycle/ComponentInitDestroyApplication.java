package com.learn._04_advanced._04_bean_lifecycle;

import com.learn._04_advanced._04_bean_lifecycle.conf.ComponentInitDestroyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 生命周期中的「初始化和销毁阶段」，通过回调执行自定义操作。
 * 使用 @Component 注解和 @PostConstruct + @PreDestroy 注解
 * 指定创建的 bean 初始化和销毁时的回调方法
 *
 * - pen1 实例通过 @Component + @PostConstruct / @PreDestroy 可以实现
 * - pen2 实例通过 @Bean + @PostConstruct / @PreDestroy 也可以实现（不用 @Component 都可以）
 * - pen1 和 pen2 共存时，pen1 执行优先级高于 pen2
 */
public class ComponentInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        // 创建 IOC 容器并创建放入 Pen 类型的 bean
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ComponentInitDestroyConfiguration.class);
        System.out.println("<<<< 初始化 IOC 容器完成");

        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        context.close();
        System.out.println("<<<< 销毁 IOC 容器完成");
    }
}
