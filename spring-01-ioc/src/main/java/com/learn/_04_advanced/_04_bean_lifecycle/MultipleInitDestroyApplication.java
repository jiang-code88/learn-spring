package com.learn._04_advanced._04_bean_lifecycle;

import com.learn._04_advanced._04_bean_lifecycle.conf.MultipleInitDestroyConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 将三种 @Bean配置 / @PostConstruct+@PreDestroy注解配置 / InitializingBean+DisposableBean接口配置的
 * 初始化和销毁回调方法都融合到一个 Multiple 类型的 bean 中。
 *  - 执行顺序为: @PostConstruct+@PreDestroy 注解
 *                  -> InitializingBean+DisposableBean接口
 *                      -> @Bean(initMethod+destroyMethod) 属性
 */
public class MultipleInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        // IOC 容器中将创建并放入 Multiple 类型的 bean
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                        MultipleInitDestroyConfiguration.class);
        System.out.println("<<<< 初始化 IOC 容器完成");

        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        context.close(); // 容器销毁, IOC 容器中单实例的 bean 将被销毁
        System.out.println("<<<< 销毁 IOC 容器完成");

    }
}
