package com.learn._04_AOP_anno;

import com.learn._04_AOP_anno.conf.AspectJAOPConfiguration;
import com.learn._04_AOP_anno.service.FinanceService;
import com.learn._04_AOP_anno.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 注解式配置 AOP（整合 AspectJ 实现的）的通知类型：
 *  1. Before 前置通知：目标对象的方法调用之前触发
 *  2. After 后置通知：目标对象的方法调用之后触发
 *  3. AfterReturning 返回通知：目标对象的方法调用完成，在返回结果值之后触发
 *  4. AfterThrowing 异常通知：目标对象的方法运行中抛出 / 触发异常后触发
 *  5. Around 环绕通知：编程式控制目标对象的方法调用
 *    同一个切面类中，环绕通知的执行时机在其他单个通知的「外层」。
 *
 * 实现步骤：
 *  1. IOC 容器配置类中添加 @EnableAspectJAutoProxy 注解，开启注解式 AOP。
 *  2. 切面类标记 @Component 注解，将其注册到 IOC 容器中，
 *     标记 @Aspect 注解，注册该类为切面类。
 *  3. 在切面类中，添加切面方法实现切面功能。
 *  4. 切面方法标记「切面通知注解（切入时机）」+「切入点表达式（切入位置）」，方法内部定义切入时要执行的操作（切入操作）。
 *     - 环绕通知切入使用 ProceedingJoinPoint 入参，实现对代理方法的 invoke 执行。
 *     - 通用切入点表达式定义：@Pointcut + 切入点表达式 + 空方法。
 *        通用切入点表达式使用：切面通知注解 + 通用切入点表达式空方法名
 *     - 使用自定义注解替代切入点表达式，所有标记了 @Log 注解的方法将会被切入执行。
 *        用法：@annotation() + 注解类全限定名
 *
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrder();
        System.out.println("---------------------\n");

        FinanceService financeService = context.getBean(FinanceService.class);

        financeService.getMoneyById("abc");
        System.out.println("---------------------\n");

        financeService.addMoney(123.23);
        System.out.println("---------------------\n");

        financeService.updateMoneyById("bcd");
        System.out.println("---------------------\n");

        financeService.subtractMoneyThrowException(234.45);
        System.out.println("---------------------\n");
    }
}
