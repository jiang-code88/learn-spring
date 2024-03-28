package com.learn._04_advanced._11_BeanPostProcessor;

import com.learn._04_advanced._11_BeanPostProcessor.conf.BeanPostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 的后置处理器 BeanPostProcessor
 * - 在 bean 的初始化前后做一些额外的处理
 *  （例如预初始化 bean 的属性值、注入特定的依赖，甚至扩展生成代理对象等）
 * - 后置处理器的拦截方法，执行顺序：
 *   bean 的生命周期流程：
 *   -1-> Bean实例化
 *   -2-> 属性赋值/组件自动注入
 *                  <-- postProcessBeforeInitialization
 *   -3-> 初始化阶段方法回调「@PostConstruct -> InitializingBean -> initMethod」
 *                  <-- postProcessAfterInitialization
 *   -4-> 创建完成
 *
 * - 线性顺序表示：
 *   → BeanPostProcessor#postProcessBeforeInitialization
 *    → @PostConstruct
 *     → InitializingBean
 *      → init-method
 *       → BeanPostProcessor#postProcessAfterInitialization
 */
public class BeanPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BeanPostProcessorConfig.class);
        context.close();
    }
}
