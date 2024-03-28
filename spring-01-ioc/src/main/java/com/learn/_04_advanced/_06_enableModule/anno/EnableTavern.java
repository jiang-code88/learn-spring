package com.learn._04_advanced._06_enableModule.anno;

import com.learn._04_advanced._06_enableModule.bean.Boss;
import com.learn._04_advanced._06_enableModule.module.BartenderConfiguration;
import com.learn._04_advanced._06_enableModule.module.Registrar.WaiterRegistrar;
import com.learn._04_advanced._06_enableModule.module.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动装配「酒馆」模块的注解
 *
 * @Import 注解支持导入以下类型的类（通过参数指定）
 *  - 普通类: {regular component classes}
 *  - 配置类: {Configuration}
 *  - 声明式导入类: {ImportSelector}
 *  - 编程式导入类: {ImportBeanDefinitionRegistrar}
  */
@Documented
@Retention(RetentionPolicy.RUNTIME) // 表示在运行时生效
@Target(ElementType.TYPE)           // 表示只能标记在类上
// 配置自动装配该模块时所需要导入的 bean
@Import({Boss.class,                  // 导入普通类 bean
        BartenderConfiguration.class, // 导入配置类中的 bean
        BarImportSelector.class,      // 使用 ImportSelector 实现类导入（ImportSelector 支持导入普通类和配置类）
        WaiterRegistrar.class})       // 使用 ImportBeanDefinitionRegistrar 实现类导入
public @interface EnableTavern {

}
