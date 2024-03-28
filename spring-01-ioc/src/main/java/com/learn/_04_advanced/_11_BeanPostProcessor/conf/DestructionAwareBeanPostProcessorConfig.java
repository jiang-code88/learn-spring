package com.learn._04_advanced._11_BeanPostProcessor.conf;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Bird;
import com.learn._04_advanced._11_BeanPostProcessor.processor.AnimalDestructionAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestructionAwareBeanPostProcessorConfig {
    // 给 Bird 类型的 bean 注册三种类型的生命周期摧毁阶段回调方法，
    // 用于对比实例摧毁阶段后置处理器的，展示它们的执行顺序差异。
    @Bean(destroyMethod = "destroyMethod")
    public Bird bird(){
        return new Bird();
    }

    @Bean
    public AnimalDestructionAwareBeanPostProcessor
    animalDestructionAwareBeanPostProcessor(){
        return new AnimalDestructionAwareBeanPostProcessor();
    }
}
