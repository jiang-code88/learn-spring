package com.learn._04_advanced._09_advance_componentScan.basePackageClassesComponentScan;

import com.learn._04_advanced._09_advance_componentScan.basePackageClassesComponentScan.config.basePackageClassComponentScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @ComponentScan 组件扫描的高级用法：
 * 支持传递具体类的类型，扫描传入的这些 Class 所在包及子包下的所有组件
 */
public class basePackageClassComponentScanApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        basePackageClassComponentScanConfig.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
