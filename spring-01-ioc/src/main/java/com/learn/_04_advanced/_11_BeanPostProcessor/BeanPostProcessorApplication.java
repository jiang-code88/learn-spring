package com.learn._04_advanced._11_BeanPostProcessor;

import com.learn._04_advanced._11_BeanPostProcessor.conf.BeanPostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 的后置处理器 BeanPostProcessor
 *
 * - 在 bean 的初始化前后做一些额外的处理
 *  （例如预初始化 bean 的属性值、注入特定的依赖，甚至扩展生成代理对象等）
 *
 * - 后置处理器的拦截方法，执行顺序：
 *   bean 的生命周期流程：
 *   -1-> Bean实例化
 *   -2-> 属性赋值/组件自动注入
 *                  <-- BeanPostProcessor.postProcessBeforeInitialization
 *   -3-> 初始化阶段方法回调「@PostConstruct -> InitializingBean -> initMethod」
 *                  <-- BeanPostProcessor.postProcessAfterInitialization
 *   -4-> 创建完成
 *
 * - 线性顺序表示：
 *   → BeanPostProcessor.postProcessBeforeInitialization
 *    → @PostConstruct
 *     → InitializingBean
 *      → init-method
 *       → BeanPostProcessor.postProcessAfterInitialization
 *
 * - 「@PostConstruct -> InitializingBean -> initMethod」是 bean 定义的专属自己的初始化回调方法。
 *    BeanPostProcessor 的 postProcessBeforeInitialization 和 postProcessAfterInitialization
 *    是 Spring 框架定义的对容器每一个 bean 的初始化回调方法。
 */
public class BeanPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BeanPostProcessorConfig.class);
        context.close();
    }
}
