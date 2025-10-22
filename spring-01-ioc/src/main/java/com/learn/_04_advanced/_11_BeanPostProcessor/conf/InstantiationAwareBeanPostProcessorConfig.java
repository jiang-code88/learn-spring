package com.learn._04_advanced._11_BeanPostProcessor.conf;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Ball;
import com.learn._04_advanced._11_BeanPostProcessor.processor.AnimalInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InstantiationAwareBeanPostProcessorConfig {
    // 容器创建 beanName 为 "ball" 的实例，后续会被拦截器拦截替换掉实例。
    @Bean
    public Ball ball(){
        Ball ball = new Ball();
        ball.setName("init ball");
        return ball;
    }

    @Bean
    public Ball ball2(){
        Ball ball = new Ball();
        return ball;
    }

    @Bean
    public AnimalInstantiationAwareBeanPostProcessor
    animalInstantiationAwareBeanPostProcessor(){
        return new AnimalInstantiationAwareBeanPostProcessor();
    }
}
