package com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.filter.GreenFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/**
 * 按注解包含
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件
 * 2 配置按注解包含的过滤扫描规则：标记 @Animal 注解的组件导入 IOC 容器中。
 *  -  @ComponentScan 注解默认配置 useDefaultFilters = true
 *     表示默认扫描并注入被 @Component 、@Repository 、@Service 或 @Controller 注解标记的类。
 *     包含型的过滤规则会和其他包含型的过滤规则组合使用（并集）。
 */
// @ComponentScan(
//         basePackages =
//                 "com.learn._04_advance._09_advance_componentScan.filterComponentScan",
//         includeFilters = @ComponentScan.Filter(
//                 type = FilterType.ANNOTATION,
//                 value = Animals.class)
// )

/**
 * 按注解排除
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件
 * 2 配置按注解排除的过滤扫描规则：标记 @Animal 注解的组件排除导入 IOC 容器中。
 *  - 排除型过滤器会排除掉其他过滤规则已经包含进来的 Bean
 */
// @ComponentScan(
//         basePackages =
//                 "com.learn._04_advance._09_advance_componentScan.filterComponentScan",
//         excludeFilters = @ComponentScan.Filter(
//                 type = FilterType.ANNOTATION,
//                 value = Animals.class)
// )

/**
 * 按类类型包含
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件
 * 2 配置按类型包含的过滤扫描规则：Color 类型的类导入 IOC 容器
 *  - Color 类以及其子类（Rea、Yellow）都会被导入容器
 */
// @ComponentScan(
//         basePackages =
//                 "com.learn._04_advance._09_advance_componentScan.filterComponentScan",
//         includeFilters = @ComponentScan.Filter(
//                 type = FilterType.ASSIGNABLE_TYPE,
//                 value = Color.class)
// )

/**
 * 按类类型排除
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件
 * 2 配置按类型排除的过滤扫描规则：Color 类型的类排除导入 IOC 容器
 *  - Color 类以及其子类（Rea、Yellow）都会被排除导入容器
 */
// @ComponentScan(
//         basePackages =
//                 "com.learn._04_advance._09_advance_componentScan.filterComponentScan",
//         excludeFilters = @ComponentScan.Filter(
//                 type = FilterType.ASSIGNABLE_TYPE,
//                 value = Color.class)
// )

/**
 * 按正则表达式过滤
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件
 * 2 配置将 com.learn._04_advance._09_advance_componentScan.filterComponentScan 包
 *   以及所有子包中以 "Demo" 开头的类注入容器。
 * 3 DemoDao.class 和 DemoService.class 将匹配扫描导入容器
 *
 * 每一个 ComponentScan 注解相当于执行一次包扫描，最后的结果是所有包扫描得到的 bean 汇总
 */
@ComponentScan(
        basePackages =
                "com.learn._04_advanced._09_advance_componentScan.filterComponentScan",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "com.learn._04_advanced._09_advance_componentScan.filterComponentScan.+Demo.+")
)

/**
 * 编程式自定义过滤规则
 * 1 配置扫描 filterComponentScan 包以及其子包中的组件。
 * 2 配置使用编程式的自定义过滤器，控制直接将 Green 排除导入 IOC 容器。
 */
// @ComponentScan(
//         basePackages =
//                 "com.learn._04_advanced._09_advance_componentScan.filterComponentScan",
//         excludeFilters =
//                 @ComponentScan.Filter(type = FilterType.CUSTOM, value = GreenFilter.class)
// )
public class FilterComponentScanConfig {
}
