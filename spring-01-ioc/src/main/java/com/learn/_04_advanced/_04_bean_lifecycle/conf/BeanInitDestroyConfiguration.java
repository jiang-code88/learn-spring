package com.learn._04_advanced._04_bean_lifecycle.conf;


import com.learn._04_advanced._04_bean_lifecycle.bean.Cat ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 @Bean 注解的 initMethod 和 destroyMethod 属性
 * 指定 bean 初始化和销毁阶段具体要调用的回调函数。
 *
 * 回调函数必备特征：
 *  - 方法访问权限无限制要求（public 还是 private 并不影响）
 *  - 方法无参数
 *  - 方法无返回值
 *  - 可以抛出异常（异常不由自己处理，交予 SpringFramework 可以打断 Bean 的初始化 / 销毁步骤）
 */
@Configuration
public class BeanInitDestroyConfiguration {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat(){
        Cat cat = new Cat();
        cat.setName("@Bean(initMethod+destroyMethod) : cat");
        return cat;
    }
}
