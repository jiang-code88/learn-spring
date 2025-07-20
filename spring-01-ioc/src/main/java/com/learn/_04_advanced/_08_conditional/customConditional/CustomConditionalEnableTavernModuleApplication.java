package com.learn._04_advanced._08_conditional.customConditional;


import com.learn._04_advanced._08_conditional.customConditional.conf.ConditionalEnableTavernModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * Spring 条件装配之 Conditional
 * 需求：
 *  - 抽取一个应用中存在某个类型 bean 时才创建 bean 的通用 Condition 条件。
 *  - 抽取一个 @ConditionOnBean 自定义注解，其 value 属性用于指定需要存在 bean 的类型，
 *    当容器中存在该类型的 bean 时才会导入这个 @ConditionOnBean 注解标记的 bean。
 *  - @ConditionOnBean 注解内部配置 onBeanCondition 这个条件匹配规则类中实现的自定义匹配条件。
 */
public class CustomConditionalEnableTavernModuleApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        ConditionalEnableTavernModuleConfig.class);

        // beanName 是 "barConfigurationSelector" 的 bean 是否导入
        // 依赖于条件(Boss 类型的 bean 是否有导入)
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
    }
}
