package com.learn._04_advanced._07_profile;

import com.learn._04_advanced._07_profile.conf.EnableTavernModuleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.stream.Stream;


/**
 * Spring 的条件装配
 *  - @profile 注解是根据当前项目的运行时环境不同，可以动态的注册当前运行环境匹配的组件
 *  - @Profile 注解可以标注在组件上，当一个配置属性（并不是文件）激活时，
 *    它才会起作用，而激活这个属性的方式有很多种（启动参数、环境变量、web.xml 配置等）
 *  - 默认情况下，ApplicationContext 中的 profile 为 “default”
 *
 * 需求
 *  - 调酒师只有在城市才会导存在, 如果是不在城市的荒郊野岭则不存在。
 *  - 使用 @Profile 配置 Bartender 实例的注入条件，为应用环境变量的 profile 为 “city”
 *  - 默认情况下，ApplicationContext 中的 profile 为 “default”，
 *    如果被设置为 “city” 则匹配 Bartender 组件的注入条件，注入组件 bean。如果不匹配则不注入。
 */
public class ProfileEnableTavernModuleApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        // 1. 通过容器环境变量设置 profile 条件
        // 给 ApplicationContext 的环境设置 profile 配置
        // context.getEnvironment().setActiveProfiles("city");
        context.register(EnableTavernModuleConfig.class);
        context.refresh();

        // 2. 通过启动参数设置 profile 条件
        // VM options: -Dspring.profiles.active=city

        // profile 配置设置了 “city” 条件才会导入 Bartender 实例，否则不会导入。
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
