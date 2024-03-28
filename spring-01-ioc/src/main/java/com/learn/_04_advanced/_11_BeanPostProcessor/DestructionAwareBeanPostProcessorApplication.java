package com.learn._04_advanced._11_BeanPostProcessor;

import com.learn._04_advanced._11_BeanPostProcessor.conf.DestructionAwareBeanPostProcessorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在 bean 销毁阶段拦截的 DestructionAwareBeanPostProcessor 后置处理器
 *  - 在实例的销毁阶段前，拦截执行处理器逻辑。
 *
 *  拦截执行时机：
 *  -0->               <-- postProcessBeforeDestruction
 *  -1->「@PreDestroy -> DisposableBean -> destroyMethod」
 *  -2-> 实例的销毁
 */
public class DestructionAwareBeanPostProcessorApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        DestructionAwareBeanPostProcessorConfig.class);
        context.close();
    }
}
