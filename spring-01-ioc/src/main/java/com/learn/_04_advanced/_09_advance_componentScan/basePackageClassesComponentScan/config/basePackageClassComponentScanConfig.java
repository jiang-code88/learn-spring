package com.learn._04_advanced._09_advance_componentScan.basePackageClassesComponentScan.config;

import com.learn._04_advanced._09_advance_componentScan.basePackageClassesComponentScan.component.DemoComponent;
import com.learn._04_advanced._09_advance_componentScan.basePackageClassesComponentScan.bean.DemoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 组件扫描注解不止可以传递包的全限定名, 还可以传递具体类 Class。
 * 指定类的类型将扫描这些 Class 所在包以及其子包下的所有组件。
 *  1 指定 DemoService.class 将扫描导入 DemoService 和 DemoDao 的 bean
 *  2 指定 DemoComponent.class 将扫描导入 DemoComponent 和该类所在包及其子包中 InnerComponent 的 bean
 */
@Configuration
@ComponentScan(basePackageClasses ={ DemoService.class, DemoComponent.class})
public class basePackageClassComponentScanConfig {

}
