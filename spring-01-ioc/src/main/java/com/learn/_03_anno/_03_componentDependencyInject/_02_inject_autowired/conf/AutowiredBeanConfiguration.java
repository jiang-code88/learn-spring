package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.conf;

import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.Dog;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogConfigurationBeanInject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 在配置类 @Bean 注解创建的 bean 中使用 @Autowired 进行依赖注入
 *  - 即使不加 @Autowired 注解，也会自动通过该方法的参数注入 IOC 容器中和方法参数同类型的 bean
 */
@Configuration
@ComponentScan("com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean")
public class AutowiredBeanConfiguration {

    @Bean
    // @Autowired
    public DogConfigurationBeanInject dogConfigurationBeanInject(Dog dog){
        DogConfigurationBeanInject dogConfigurationBeanInject = new DogConfigurationBeanInject();
        dogConfigurationBeanInject.setName("helloDogConfigurationBeanInject");
        dogConfigurationBeanInject.setDog(dog);
        return dogConfigurationBeanInject;
    }
}
