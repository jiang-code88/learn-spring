package com.learn._04_AOP_anno.conf;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * IOC 容器配置类
 *  - exposeProxy 是高级功能（默认 false）表示开启暴露切面的代理对象，
 *    实现切入方法内部再次通过代理对象调用代理方法，持续获得切面的增强。
 */
@Configuration
@ComponentScan({"com.learn._04_AOP_anno.service", "com.learn._04_AOP_anno.aop"})
@EnableAspectJAutoProxy(exposeProxy = true) // 在配置类中开启注解式 AOP
public class AspectJAOPConfiguration {

    @Before("FinanceServiceMethodPointcut()")
    public void beforeMethodPrintPointcut() {
        System.out.println("Aspect @Before + @Pointcut run ......");
    }

}