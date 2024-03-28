package com.learn._04_advanced._09_advance_componentScan.filterComponentScan;

import com.learn._04_advanced._09_advance_componentScan.filterComponentScan.conf.FilterComponentScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @ComponentScan 组件扫描的高级用法：按规则过滤包扫描
 *
 * 场景：
 *  1  Cat 、Dog 、Pikachu 类，均标记 @Component 注解，
 *     只有 Cat 和 Dog 上标注 @Animal 注解。
 *  2 Color 是一个父类，Red 、Yellow、Green 类均标记 @Component 注解，
 *    Red 和 Yellow 继承 Color，Green 没有继承 Color。
 *  3. DemoService 与 DemoDao 是普通类。
 *
 * 提供以下规则过滤（包含或排除组件导入容器）包扫描
 *  - 按注解过滤
 *  - 按类类型过滤
 *  - 按表达式规则（正则表达式）过滤
 *  - 按编程式自定义规则过滤
 * 详见 FilterComponentScanConfig 类中提供的包扫描例子
 */
public class FilterComponentScanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        FilterComponentScanConfig.class);
        Stream.of(context.getBeanDefinitionNames()).
                forEach(System.out::println);
    }
}
