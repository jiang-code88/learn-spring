package com.learn._04_advanced._04_bean_lifecycle;

import com.learn._04_advanced._04_bean_lifecycle.bean.prototype.PrototypeBean;
import com.learn._04_advanced._04_bean_lifecycle.conf.PrototypeBeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 将三种 @Bean配置 / @PostConstruct+@PreDestroy注解配置 / 接口配置的
 * 初始化和销毁回调方法都融合到一个 Multiple 类型的「原型」bean 中。
 *
 *  - 原型 bean 和单例 bean 唯一不同的是 @Bean 的 destroyMethod 方法
 *    在原型 bean 中是不生效的，这个需要注意一下。
 */
public class PrototypeBeanInitDestroyApplication {
    public static void main(String[] args) {
        System.out.println(">>>> 准备初始化 IOC 容器");
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                        PrototypeBeanConfiguration.class);
        // 获取 PrototypeBean 类型的原型 bean
        System.out.println(">>>> 准备获取原型 bean");
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        System.out.println("<<<< 获取原型 bean 完成");
        System.out.println("<<<< 初始化 IOC 容器完成");
        System.out.println("\n----------------------------------\n");

        System.out.println(">>>> 准备销毁 IOC 容器");
        System.out.println(">>>> 准备销毁原型 bean");
        // 销毁 IOC 容器中的 PrototypeBean 类型的原型 bean
        context.getBeanFactory().destroyBean(prototypeBean);
        System.out.println("<<<< 销毁原型 bean 完成");
        System.out.println("<<<< 销毁 IOC 容器完成");
    }
}
