package com.learn._04_advanced._08_conditional.basicUsage.condition;

import com.learn._04_advanced._08_conditional.basicUsage.bean.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现 Condition 接口, 定义条件导入的匹配规则
 *  - 定义是否导入的匹配规则, 匹配所有规则时导入, 否则不导入
 */
public class ExistBossCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        // 匹配规则：是否存在 beanName 为
        // com.learn._04_advance._08_conditional.basicUsage.bean.Boss 的 BeanDefinition
        // 查找 beanDefinition 的理由是，防止条件匹配时，Boss 对象还没被创建完成，
        // 导致条件判断出现偏差。
        return context.getBeanFactory().
                containsBeanDefinition(Boss.class.getName());
    }
}
