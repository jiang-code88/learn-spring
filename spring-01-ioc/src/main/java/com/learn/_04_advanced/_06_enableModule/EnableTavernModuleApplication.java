package com.learn._04_advanced._06_enableModule;


import com.learn._04_advanced._06_enableModule.conf.EnableTavernModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * spring 模块装配
 *
 * 模块状态出现的背景：原生手动装配的麻烦。
 *  - 如果注册很多 bean 要么要么一个一个的 @Bean 编程式写，
 *    要么每个类都标注好 @Component 或者它的衍生模式注解，十分麻烦。
 * 模块状态的优点：某个功能模块的所有组件（类的实例对象）可以一键引入或移除。
 * 模块装配的核心原则：通过「自定义注解」+「@Import 注解」导入组件。
 *
 *  需求：
 *  - 模块: "酒馆" Tavern
 *  - 模块组件:「老板，调酒师，吧台, 服务员」
 *     - 老板 Boss: 普通类导入
 *     - 调酒师 Bartender: 配置类导入
 *     - 吧台 Bar: 实现 ImportSelector 接口导入
 *     - 服务员 Waiter: 实现 ImportBeanDefinitionRegistrar 接口导入
 *  - 效果：实现通过一个注解即可将「酒馆模块」的所有组件填充到应用中。
 */
public class EnableTavernModuleApplication {
    public static void main(String[] args) {
        // 在容器的 EnableTavernModuleConfig 配置类标记 @EnableTavern 即可装配「酒馆」模块
        ApplicationContext context =
                 new AnnotationConfigApplicationContext(
                         EnableTavernModuleConfig.class);

        // 打印容器中存在的所有 bean
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
