package com.learn._03_anno._03_componentDependencyInject._02_inject_autowired;

import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.Dog;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.bean.DogConfigurationBeanInject;
import com.learn._03_anno._03_componentDependencyInject._02_inject_autowired.conf.AutowiredBeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Autowired 注解对配置类中 @Bean 注解创建的 bean 进行自动依赖注入
 * 对应的配置类为 AutowiredBeanConfiguration
 */
public class AutowiredConfigurationBeanApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AutowiredBeanConfiguration.class);

        // 容器中存在一个 Dog 类型的 bean 名为 dog
        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);

        // @Configuration + @Bean 创建的 bean 也可以使用
        // @Autowired 注解自动注入容器中 Dog 类型的 bean
        DogConfigurationBeanInject dogConfigurationBeanInject =
                context.getBean("dogConfigurationBeanInject",
                        DogConfigurationBeanInject.class);
        System.out.println(dogConfigurationBeanInject);
    }
}
