package com.learn._04_advanced._08_conditional.basicUsage.module.selector;

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
    @Conditional(ExistBossCondition.class)
    public Bar barConfigurationSelector(){
        return new Bar();
    }
}
