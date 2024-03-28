package com.learn._04_advanced._08_conditional.basicUsage.module.selector;

import com.learn._04_advanced._08_conditional.basicUsage.bean.Bar;
import com.learn._04_advanced._08_conditional.basicUsage.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类中 bean 会被 BarImportSelector 导入 IOC 容器中
 */
@Configuration
public class BarConfiguration {

    @Bean
    // 标注 @Conditional 注解的 Bean 要注册到 IOC 容器时，
    // 必须全部满足 @Conditional 上指定的所有条件才可以。
    // @Conditional 注解中需要传入一个 Condition 接口的实现类数组,
    // 通过实现方法中定义的匹配规则决定是否导入
    @Conditional(ExistBossCondition.class)
    public Bar BBbar(){
        return new Bar();
    }
}
