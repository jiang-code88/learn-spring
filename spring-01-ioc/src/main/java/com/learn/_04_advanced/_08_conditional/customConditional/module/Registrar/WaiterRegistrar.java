package com.learn._04_advanced._08_conditional.customConditional.module.Registrar;

import com.learn._04_advanced._08_conditional.customConditional.bean.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 使用 ImportBeanDefinitionRegistrar 导入 Waiter 实例
 *  - 实际导入的是 BeanDefinition（Bean 的定义信息）
 */
public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata,
            BeanDefinitionRegistry registry) {
        // 第一个参数配置 bean 的 beanName
        // 第二个参数配置 RootBeanDefinition 要指定 Bean 的字节码（ .class ）
        registry.registerBeanDefinition("waiter-bean",
                new RootBeanDefinition(Waiter.class));
    }
}
