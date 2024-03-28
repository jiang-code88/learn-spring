package com.learn._04_advanced._11_BeanPostProcessor.conf;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Cat;
import com.learn._04_advanced._11_BeanPostProcessor.processor.AnimalBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {
    // 给 Cat 类型的 bean 注册三种类型的生命周期初始化阶段回调方法，
    // 用于对比后置处理器的两个拦截方法，展示它们的执行顺序差异。
    @Bean(initMethod = "initMethod")
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("Timmy");
        return cat;
    }

    @Bean
    public AnimalBeanPostProcessor animalBeanPostProcessor(){
        return new AnimalBeanPostProcessor();
    }
}
