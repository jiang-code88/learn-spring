package com.learn._04_advanced._11_BeanPostProcessor;

import com.learn._04_advanced._11_BeanPostProcessor.bean.Ball;
import com.learn._04_advanced._11_BeanPostProcessor.conf.InstantiationAwareBeanPostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 实例化阶段拦截处理的 InstantiationAwareBeanPostProcessor 后置处理器
 *  - postProcessBeforeInitialization 方法可在 bean 实例化前拦截，替换 bean 的实现。
 *  - postProcessProperties 方法可在 bean 实例化后，依赖注入前，替换注入 bean 的属性。
 *              <-- postProcessBeforeInitialization
 *  -1-> Bean实例化
 *              <-- postProcessProperties
 *  -2-> 属性赋值/组件自动注入
 *  -3-> 初始化阶段方法回调「@PostConstruct -> InitializingBean -> initMethod」
 *  -4-> 创建完成
 *
 *  注意：postProcessBeforeInstantiation 方法执行完毕后，
 *        并不会再执行 postProcessProperties。
 *       （也就是 postProcessProperties 方法没有机会能再影响
 *        postProcessBeforeInstantiation 方法创建出来的对象）
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
