package com.learn._04_advanced._01_factoryBean;

import com.learn._04_advanced._01_factoryBean.bean.Toy;
import com.learn._04_advanced._01_factoryBean.bean.ToyFactoryBean;
import com.learn._04_advanced._01_factoryBean.conf.FactoryBeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * 借助 FactoryBean 使用工厂方法，创建一些初始化流程比较复杂的 bean
 *
 * FactoryBean 是一个接口，实现其并在其实现中指定实际 bean 的创建逻辑
 *  - getObject() 方法：返回该 FactoryBean 所要创建的 bean
 *  - getObjectType() 方法：返回 FactoryBean 创建 bean 的类型
 *  - isSingleton() 方法：返回该 FactoryBean 创建的对象是单实例 Bean 还是原型 Bean, 默认单实例
 *
 * 场景：
 *  - ToyFactoryBean 用于生产玩具 bean
 *  - 有两种类型的玩具 Ball 和 Car，他们都是 Toy 的子类。
 *  - ToyFactoryBean 中判断其传入的 Child 实例中的 wantToy 属性值，
 *    判断生产 Ball 还是 Car。
 *  - 在容器配置类中，生成一个 Child 类型的 bean 指定生成那种玩具。
 *    生成一个 ToyFactoryBean 类型的 bean（注入 Child 类型的 bean）用于生成 Ball 或 Car 实例
 *
 * FactoryBean 的机制：
 *  - FactoryBean 本身的加载(实例化)是伴随 IOC 容器的初始化, 一起加载到容器中的
 *  - FactoryBean 生产 Bean 的机制是延迟生产, 即当调用容器的 getBean() 方法获取对应类型 bean 时,
 *    IOC 容器才会自动识别, 调用 FactoryBean 的 getObject() 方法创建对应的 bean;
 *  - 针对默认的单实例 FactoryBean, 第一次调用 getBean() 方法创建的对应 bean 会被缓存起来,
 *    后续 getBean() 获取的都是同一个 bean 即缓存起来的那个 bean。
 */
public class FactoryBeanApplication {
    public static void main(String[] args) {
        System.out.println("1--------------------------------------------------");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        FactoryBeanConfiguration.class);
        System.out.println(">>>1>>> 初始化 IOC 容器完成");

        Toy toyBean = context.getBean(Toy.class);
        System.out.println(">>>2>>> 获取 ToyFactoryBean 创建的 Toy 类型的 bean");
        System.out.println(toyBean);


        System.out.println("2--------------------------------------------------");
        // Toy 类型(Ball/Car)的 bean 的 beanName 其实是 "toyFactoryBean"
        String[] namesForType = context.getBeanNamesForType(Toy.class);
        Stream.of(namesForType).forEach(System.out::println);
        // 通过 "toyFactoryBean" 这个名字获取的 bean 是
        // FactoryBean 创建的 Toy 类型的 bean,不是 FactoryBean 本身的 bean
        System.out.println(context.getBean("toyFactoryBean"));


        System.out.println("3--------------------------------------------------");
        // 获取容器中所有 bean 的 beanName, 是会发现 IOC 容器中并不存在 ToyFactoryBean 类型的 bean
        // 但其实它是存在于 IOC 容器的, 只是获取其的意义不大，被 IOC 容器隐藏起来没有显示
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);


        System.out.println("4--------------------------------------------------");
        // 通过 ToyFactoryBean 类型即可获取 IOC 容器中 FactoryBean 的本身的 bean
        ToyFactoryBean toFactoryBean = context.getBean(ToyFactoryBean.class);
        System.out.println(toFactoryBean);


        System.out.println("5--------------------------------------------------");
        // IOC 容器中 ToyFactoryBean.class 本身的 bean 的 beanName
        // 其实叫做 &toyFactoryBean (在名称开头增加了一个 "&" 字符)
        System.out.println(context.getBean("&toyFactoryBean"));


        System.out.println("6--------------------------------------------------");
        // 如果通过 isSingleton() 指定 FactoryBean 生成的 bean 是单例的, 那么多次获取的将都是同一个 bean
        Toy toyA = context.getBean(Toy.class);
        Toy toyB = context.getBean(Toy.class);
        // 对比两次从容器中获取的 bean 的内存地址, 是否相同
        System.out.println(toyA == toyB);

    }
}
