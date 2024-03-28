package com.learn._04_advanced._02_bean_scope.conf;

import com.learn._04_advanced._02_bean_scope.bean.Child;
import com.learn._04_advanced._02_bean_scope.bean.ToyPrototype;
import com.learn._04_advanced._02_bean_scope.bean.ToySingleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._04_advanced._02_bean_scope.bean")
public class BeanScopeConfiguration {
    // 创建两个 Child 类型的 bean
    @Bean
    public Child childA(ToySingleton toySingleton, ToyPrototype toyPrototype){
        Child child = new Child();
        child.setToySingleton(toySingleton);
        child.setToyPrototype(toyPrototype);
        return child;
    }

    @Bean
    public Child childB(ToySingleton toySingleton, ToyPrototype toyPrototype){
        Child child = new Child();
        child.setToySingleton(toySingleton);
        child.setToyPrototype(toyPrototype);
        return child;
    }
}
