package com.learn._03_anno._01_BeanDependencyLookupAndInject.conf;

import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Item;
import com.learn._03_anno._01_BeanDependencyLookupAndInject.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // @Configuration 注解和 @Bean 注解要一起配对使用才生效
    @Bean
    public Person person(){
        return new Person();
    }

    // 向 IOC 容器注册一个类型为 Person, id 为 person 的 Bean
    // 方法的返回值代表注册 bean 的类型，方法名代表 Bean 的 id
    @Bean
    public Person personA(){
        return new Person();
    }

    @Bean
    public Person personB(){
        Person person = new Person();
        // 使用 setter 方法注入 @Bean 注入容器的 bean
        // 相当于 value 属性
        person.setName("abc");
        person.setAge(23);
        // 相当于 xml 配置的 ref 属性
        person.setItem(item());
        return person;
    }

    @Bean
    public Person personC(){
        // 使用构造器依赖注入 @Bean 创建到容器的 bean
        return new Person("mica",45,item());
    }

    // 可以直接在 @Bean 注解上显式的声明 Bean 的 id（在注解中 id 被称为 name）
    @Bean("xxitemxx")
    public Item item(){
        return new Item();
    }

}
