package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 按正则表达式过滤
 * 1 配置扫描 filterComponentScan.bean 包以及其子包中的组件
 * 2 配置将 com.learn._04_advance._09_advance_componentScan.filterComponentScan.bean 包
 *   以及其所有子包中以 "Demo" 开头的类注入容器，
 *   所以 DemoDao.class 和 DemoService.class 将匹配扫描导入容器
 *
 * 每一个 ComponentScan 注解相当于执行一次包扫描，最后的结果是所有包扫描得到的 bean 汇总
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.bean.+Demo.+")
)
@Configuration
public class RegexIncludeFilterComponentScanConfiguration {
}
