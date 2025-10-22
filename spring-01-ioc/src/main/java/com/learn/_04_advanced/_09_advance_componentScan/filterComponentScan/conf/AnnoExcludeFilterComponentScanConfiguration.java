package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.anno.Animals;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 按注解排除
 * 1 配置扫描 filterComponentScan.bean.animals 包以及其子包中的组件
 * 2 配置按注解排除的过滤扫描规则：标记 @Animal 注解的组件排除导入 IOC 容器中，Pikachu 会被导入。
 *   - 排除型过滤器会排除掉其他过滤规则已经包含进来的 Bean
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.animals",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = Animals.class))
@Configuration
public class AnnoExcludeFilterComponentScanConfiguration {
}
