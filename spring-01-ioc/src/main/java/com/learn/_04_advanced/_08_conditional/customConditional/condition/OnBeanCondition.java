package com.learn._04_advanced._08_conditional.customConditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 定义 @ConditionalOnBean 注解的条件导入匹配条件
 */
public class OnBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        // 1 获取目标自定义注解 ConditionalOnBean 上的 beanNames 属性
        Class<?>[] beans = (Class<?>[]) metadata
                .getAnnotationAttributes(ConditionalOnBean.class.getName())
                .get("value");

        // 2 逐个校验 IOC 容器中是否包含传入的 beanName
        for(Class<?> bean : beans){
            if(context.getBeanFactory().containsBeanDefinition(bean.getName())){
                return true;
            }
        }
        return false;
    }
}
