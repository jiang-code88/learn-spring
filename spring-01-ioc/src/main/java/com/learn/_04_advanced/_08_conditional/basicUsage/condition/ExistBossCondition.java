package com.learn._04_advanced._08_conditional.basicUsage.condition;

import com.learn._04_advanced._08_conditional.basicUsage.module.bean.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 条件匹配规则类实现 Condition 接口, 定义条件导入的匹配规则
 *  - 定义是否导入的匹配规则, 匹配所有规则时导入, 否则不导入
 */
public class ExistBossCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        // 匹配规则：beanName 为 com.learn._04_advanced._08_conditional.basicUsage.module.bean.Boss
        // 的 BeanDefinition 存在则为匹配规则导入，不存在则为不匹配规则不导入。
        // 注意：这里查找 beanDefinition 的理由是，如果条件匹配时，Boss 对象还没被创建完成，
        // 条件判断将出现偏差，判断到 Boss 是不存在的，实际上 Boss 是存在的（只是尚未创建完成）
        // 而 beanDefinition 从一开始就能判断出是否存在，不受是否创建完成影响，能否规避条件判断的偏差。
        return context.getBeanFactory()
                .containsBeanDefinition(Boss.class.getName());
    }
}
