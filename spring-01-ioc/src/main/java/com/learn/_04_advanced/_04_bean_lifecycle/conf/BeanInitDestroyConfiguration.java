package com.learn._04_advanced._04_bean_lifecycle.conf;


import com.learn._04_advanced._04_bean_lifecycle.bean.Cat ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 @Bean 注解的 initMethod 和 destroyMethod 属性
 * 指定 bean 初始化和销毁阶段具体要调用的回调函数。
 */
@Configuration
public class BeanInitDestroyConfiguration {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("cat");
        return cat;
    }
}
