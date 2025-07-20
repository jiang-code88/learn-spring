package com.learn._04_advanced._07_profile.module.registrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 使用 ImportBeanDefinitionRegistrar 导入 Waiter 实例
 *  - 实际导入的是 BeanDefinition（Bean 的定义信息）
 *  - WaiterRegistrar 本身不会被创建 bean 放入容器中。
 */
public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        // 第一个参数配置 bean 的 beanName
        // 第二个参数配置 RootBeanDefinition 要指定 Bean 的字节码（.class）
        registry.registerBeanDefinition("waiter-Register",
                new RootBeanDefinition(Waiter.class));
    }
}
