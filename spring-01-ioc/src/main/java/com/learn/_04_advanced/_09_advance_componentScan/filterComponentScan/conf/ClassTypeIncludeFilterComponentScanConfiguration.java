package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.color.Color;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 按类类型包含
 * 1 配置扫描 filterComponentScan.bean 包以及其子包中的组件
 * 2 配置按类型包含的过滤扫描规则：Color 类型的类导入 IOC 容器
 *   - Color 类以及其子类（Rea、Yellow）都会被导入容器。
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.color",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = Color.class)
)
@Configuration
public class ClassTypeIncludeFilterComponentScanConfiguration {
}
