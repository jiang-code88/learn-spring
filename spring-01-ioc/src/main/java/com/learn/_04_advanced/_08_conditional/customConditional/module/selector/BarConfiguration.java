package com.learn._04_advanced._08_conditional.customConditional.module.selector;

import com.learn._04_advanced._08_conditional.customConditional.anno.ConditionalOnBean;
import com.learn._04_advanced._08_conditional.customConditional.bean.Bar;
import com.learn._04_advanced._08_conditional.customConditional.bean.Boss;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类中 bean 会被 BarImportSelector 导入 IOC 容器中
 */
@Configuration
public class BarConfiguration {
    @Bean
    @ConditionalOnBean(beans = Boss.class)
    public Bar BBbar(){
        return new Bar();
    }
}
