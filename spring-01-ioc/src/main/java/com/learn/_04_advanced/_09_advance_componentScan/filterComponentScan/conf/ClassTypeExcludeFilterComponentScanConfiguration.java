package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.color.Color;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 按类类型排除
 * 1 配置扫描 filterComponentScan.bean 包以及其子包中的组件
 * 2 配置按类型排除的过滤扫描规则：Color 类型的类排除导入 IOC 容器
 *   - Color 类的子类（Rea、Yellow）都会被排除导入容器，NotColorGreen 会被导入容器
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.color",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = Color.class)
)
@Configuration
public class ClassTypeExcludeFilterComponentScanConfiguration {
}
