package com.learn._04_advanced._08_conditional.basicUsage;


import com.learn._04_advanced._08_conditional.basicUsage.conf.ConditionalEnableTavernModuleConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * Spring 条件装配之 Conditional
 *  - @Profile 能根据整个项目的运行环境, 决定是否装配, 但无法根据单个 Bean 的因素决定是否装配，
 *    而 @Condition 注解就可以根据单个 Bean 的因素决定是否装配。
 *  - @Conditional 注解可以指定匹配条件，而被 @Conditional 注解标注的组件类/配置类/组件工厂方法
 *    必须满足 @Conditional 中指定的所有条件，才会被创建或解析。
 *  - 实现 Condition 接口的 matches 方法，在该方法中定义具体的匹配条件规则，作为「条件匹配规则类」
 *    传入 @Conditional 注解中指定匹配条件。
 *
 * 需求：应用中存在 Boss 类型 bean 时才创建 barConfigurationSelector 这个 bean。
 */
public class ConditionalEnableTavernModuleApplication {
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
