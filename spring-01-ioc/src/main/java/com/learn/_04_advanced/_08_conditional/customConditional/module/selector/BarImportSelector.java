package com.learn._04_advanced._08_conditional.customConditional.module.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;

/**
 * ImportSelector 导入 Bar 实例到 IOC 容器中：
 * 1. ImportSelector 可以导入配置类或普通类。
 * 2. ImportSelector 是一个接口，
 *    它的实现类可以根据指定的筛选标准（通常是一个或者多个注解）来决定导入哪些配置类。
 * 3. BarImportSelector 本身不会被创建 bean 放入容器中。
 */
public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        ArrayList<String> stringList = new ArrayList<>();
        // 指定普通类全限定类名导入 bean
        stringList.add(Bar.class.getName());
        // 指定配置类全限定类名导入 bean
        stringList.add(BarConfiguration.class.getName());
        return stringList.toArray(new String[0]);
    }
}
