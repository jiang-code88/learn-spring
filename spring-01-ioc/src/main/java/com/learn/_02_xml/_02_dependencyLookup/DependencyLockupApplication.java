package com.learn._02_xml._02_dependencyLookup;

import com.learn._02_xml._02_dependencyLookup.anno.Color;
import com.learn._02_xml._02_dependencyLookup.bean.Cat;
import com.learn._02_xml._02_dependencyLookup.bean.Dog;
import com.learn._02_xml._02_dependencyLookup.bean.impl.DemoDao;
import com.learn._02_xml._02_dependencyLookup.bean.Person;
import com.learn._02_xml._02_dependencyLookup.bean.impl.InfoDao;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Ioc 容器的依赖查找机制
 */
public class DependencyLockupApplication {
    public static int i = 1;
    public static String commentText = "========%s========%n";

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "_02_xml/_02_dependencyLookup/dependencyLookup.xml");

        // 1 根据 beanName 从 Ioc 容器中获取 bean
        System.out.printf(commentText, i++);
        Person beanByName = (Person) context.getBean("per");
        System.out.println(beanByName);
        System.out.println();

        // 2 根据 beanType 从 Ioc 容器中获取 bean
        System.out.printf(commentText, i++);
        Person beanByType = context.getBean(Person.class);
        System.out.println(beanByType);
        System.out.println();

        // 3 根据接口类型从 Ioc 容器中获取接口实现类的 bean（单个）
        System.out.printf(commentText, i++);
        InfoDao infoDao = context.getBean(InfoDao.class);
        System.out.println(infoDao);
        System.out.println();

        // 4 通过接口类型从 Ioc 容器中获取所有该接口实现类的 Bean（多个）
        System.out.printf(commentText, i++);
        Map<String, DemoDao> beansOfType =
                context.getBeansOfType(DemoDao.class);
        beansOfType.forEach((beanName, bean) ->
                System.out.println(beanName + " : " + bean));
        System.out.println();

        // 5 获取被 @Color 注解标记的类的 bean
        System.out.printf(commentText, i++);
        Map<String, Object> beansWithAnnotation =
                context.getBeansWithAnnotation(Color.class);
        beansWithAnnotation.forEach((beanName, bean) ->
                System.out.println(beanName + " : " + bean));
        System.out.println();

        // 6 获取容器中所有 bean 的 BeanName
        System.out.printf(commentText, i++);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        // 使用 jdk8 的 Stream 快速编写遍历打印方法
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        System.out.println();

        // 7 延迟查找
        // 假设现在容器中不存在 Cat.class 类型的 bean
        System.out.printf(commentText, i++);
        ObjectProvider<Cat> catBeanProvider =
                context.getBeanProvider(Cat.class);
        // 找不到 Bean 时返回 null 而不抛出异常
        Cat cat = catBeanProvider.getIfAvailable();
        if (cat == null) {
            cat = new Cat();
        }
        System.out.println(cat);
        System.out.println();

        // 找不到 Bean 时直接用 Supplier 接口的方法返回默认实现
        Cat catSupplier = catBeanProvider.getIfAvailable(() -> new Cat());
        System.out.println(catSupplier);
        System.out.println();

        // 如果找到 bean 马上执行方法调用
        ObjectProvider<Dog> dogBeanProvider = context.getBeanProvider(Dog.class);
        dogBeanProvider.ifAvailable((o) -> System.out.println(o));
    }
}
