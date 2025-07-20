package com.learn._04_advanced._03_bean_instantiate;

import com.learn._04_advanced._03_bean_instantiate.bean.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.stream.Stream;

/**
 * Car 类型的实例对象可以使用 "静态工厂方法" 和 "实例工厂方法" 创建
 * 需要将 "静态工厂" 和 "实例工厂" 类注册到 IOC 容器中,
 * IOC 容器会帮助我们使用工厂方法创建 Car 类型的对象
 * - 由于注解式搭建的 IOC 容器没有提供专门的注解给工厂方法。
 *   同时在注解搭建的 IOC 容器中, 使用配置类 + @Bean 注解可以编程式的调用工厂方法创建 Bean 对象。
 * - 主要讲解基于 xml 搭建的 IOC 容器, 如何注册工厂方法到 IOC 容器中。
 */
@Deprecated // 这个内容实在冷门，暂时跳过不需要学习
public class BeanInstantiateApplication {
    public static void main(String[] args) {
        // 在 IOC 容器加载创建期间, 就会去调用 "静态工厂" 和 "实例工厂" 的工厂方法,
        // 创建 Car 类型的实例对象放入容器中
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "_04_advance/_03_bean_instantiate/beanInstantiate.xml");
        System.out.println("IOC 容器创建完成");
        System.out.println("--------------------------------------------------");

        // 1 静态工厂的实例对象不会创建放入容器中,
        //   只会调用静态工厂 getCar() 方法，创建 Car 实例对象放入 IOC 容器中。
        // 2 实例工厂的实例对象会创建放入容器中。
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");

        context.getBeansOfType(Car.class).forEach(
                (beanName, car) -> System.out.println(beanName + ":" + car)
        );
        System.out.println("--------------------------------------------------");
    }
}
