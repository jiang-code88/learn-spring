package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.filter.GreenFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 编程式自定义过滤规则
 * 1 配置扫描 filterComponentScan.bean 包以及其子包中的组件。
 * 2 配置使用编程式的自定义过滤器，控制直接将 Green 排除导入 IOC 容器。
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                value = GreenFilter.class)
)
public class CustomExcludeFilterComponentScanConfiguration {
}
