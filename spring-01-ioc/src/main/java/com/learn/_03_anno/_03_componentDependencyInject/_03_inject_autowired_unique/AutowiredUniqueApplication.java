package com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique;

import com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean.AutoWiredUniqueByFieldName;
import com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean.AutoWiredUniqueByPrimary;
import com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.bean.AutowiredUniqueByQualifier;
import com.learn._03_anno._03_componentDependencyInject._03_inject_autowired_unique.conf.AutoWiredUniqueConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @AutoWried 遇到相同类型的多个 bean 时的自动注入策略：
 *
 * 1. 例如 Cat 类通过 @Component 创建一个叫 cat1 的 bean，通过 @Bean 创建一个叫做 cat2 的类。
 * 2. zooUnique 通过 @Autowired 自动注入 Cat 依赖时，由于有两个相同类型的 bean，
 *    无法确定注入谁则跑出异常 NoUniqueBeanDefinitionException。
 *
 * 解决方案：
 *  1. 通过 @AutoWired + @Qualifier（指定具体 beanName）实现具体注入
 *  2. 通过 @Primary + @Component / @Bean 指定某个 bean 在 @AutoWired 自动注入时是优先注入
 *  3. 如果 @AutoWired 自动注入的属性名 和 beanName 一致则自动注入。
 *
 *  @Autowired 注解详细注入机制:
 *   1.先拿属性对应的类型，去 IOC 容器中找 Bean，如果找到了一个，直接返回注入；
 *   2.如果找到多个类型一样的 bean，根据 @Qualifier 指定的 beanName 去找，找到直接返回注入；
 *   3.找不到则找标记了 @Primary 注解的 bean，如果只找到一个，直接返回注入；
 *   4.否则把属性名拿过来，跟这些 bean 的 id 逐个对比，如果有一个相同的，直接返回；
 *   5.如果没有任何相同的 id 与要注入的属性名相同，则会抛出 NoUniqueBeanDefinitionException 异常。
 */
public class AutowiredUniqueApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AutoWiredUniqueConfiguration.class);

        // 使用 @Qualifier 注解指定 @Autowired 注解要注入哪一个 bean
        AutowiredUniqueByQualifier autowiredUniqueByQualifier =
                context.getBean("autowiredUniqueByQualifier",
                        AutowiredUniqueByQualifier.class);
        System.out.println(autowiredUniqueByQualifier);

        // 使用 @primary 注解指定 @Autowired 注解首选要注入哪一个 bean
        AutoWiredUniqueByPrimary autoWiredUniqueByPrimary =
                context.getBean("autoWiredUniqueByPrimary",
                        AutoWiredUniqueByPrimary.class);
        System.out.println(autoWiredUniqueByPrimary);

        // ZooByName 类中 Sheep 类型的成员变量名和 Sheep 类型 bean 的名称相同时直接注入
        AutoWiredUniqueByFieldName autoWiredUniqueByFieldName =
                context.getBean("autoWiredUniqueByFieldName",
                        AutoWiredUniqueByFieldName.class);
        System.out.println(autoWiredUniqueByFieldName);
    }
}
