package com.learn._04_advanced._01_factoryBean.conf;

import com.learn._04_advanced._01_factoryBean.bean.Child;
import com.learn._04_advanced._01_factoryBean.bean.ToyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfiguration {

    // 创建一个 child 类型的普通 bean，指定 ToyFactoryBean 生成玩具 Ball
    @Bean
    public Child child(){
        Child child = new Child();
        child.setWantToy("ball");
        return child;
    }

    // 创建一个 ToyFactoryBean 类型的 bean 用于生成 Toy 类型的 bean（Ball 或 Car）
    // - FactoryBean 本身会被实例化出一个 bean, 但它并不会被实际使用;
    // - 真正被放入 IOC 容器实际使用的是调用 FactoryBean 的 getObject() 方法
    //   创建的 Toy 类型(Ball/Car)的 bean
    @Bean
    public ToyFactoryBean toyFactoryBean(){
        ToyFactoryBean toyFactoryBean = new ToyFactoryBean();
        toyFactoryBean.setChild(child());
        return toyFactoryBean;
    }
}
