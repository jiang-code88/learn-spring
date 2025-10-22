package com.learn._04_advanced._11_BeanPostProcessor;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Ball;
import com.learn._04_advanced._11_BeanPostProcessor.conf.InstantiationAwareBeanPostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 实例化阶段拦截处理的 InstantiationAwareBeanPostProcessor 后置处理器
 *  - 其中 postProcessBeforeInitialization 方法可在 bean 实例化前拦截，替换 bean 的实现。
 *  - 其中 postProcessProperties 方法可在 bean 实例化后，依赖注入前，替换注入 bean 的属性。
 *              <-- InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization
 *  -1-> Bean实例化
 *              <-- InstantiationAwareBeanPostProcessor.postProcessProperties
 *  -2-> 属性赋值/组件自动注入
 *              <-- BeanPostProcessor.postProcessBeforeInitialization
 *  -3-> 初始化阶段方法回调「@PostConstruct -> InitializingBean -> initMethod」
 *              <-- BeanPostProcessor.postProcessAfterInitialization
 *  -4-> 创建完成
 *
 *  注意：InstantiationAwareBeanPostProcessor.postProcessProperties 不会影响
 *  InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation 也就是：
 *      postProcessBeforeInstantiation 方法执行完毕后，并不会再执行 postProcessProperties，
 *      postProcessProperties 方法没有机会能再影响 postProcessBeforeInstantiation 方法创建出来的对象
 */
public class InstantiationAwareBeanPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InstantiationAwareBeanPostProcessorConfig.class);

        Ball ball = (Ball) context.getBean("ball");
        System.out.println(ball);

        Object ball2 = context.getBean("ball2");
        System.out.println(ball2);

        context.close();
    }
}
