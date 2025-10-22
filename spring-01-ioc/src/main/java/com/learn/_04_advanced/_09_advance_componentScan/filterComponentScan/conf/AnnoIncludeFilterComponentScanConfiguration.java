package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.anno.Animals;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 按注解包含
 * 1 配置扫描 filterComponentScan.bean.animals 包以及其子包中的组件
 * 2 配置按注解包含的过滤扫描规则：标记 @Animal 注解的组件导入 IOC 容器中。
 *   - @ComponentScan 注解是默认配置 useDefaultFilters = true 的
 *     表示默认扫描并注入被 @Component 、@Repository 、@Service 或 @Controller 注解标记的类。
 *     包含型的过滤规则会和其他包含型的过滤规则组合使用（并集）。
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.animals",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = Animals.class)
)
@Configuration
public class AnnoIncludeFilterComponentScanConfiguration {
}
