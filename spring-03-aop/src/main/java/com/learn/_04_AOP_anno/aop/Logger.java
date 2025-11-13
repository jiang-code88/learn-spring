package com.learn._04_AOP_anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类（定义切面方法）
 *
 * 切面通知注解：
 * 1. @Before 前置通知：目标对象的方法调用之前触发
 * 2. @After 后置通知：目标对象的方法调用之后触发
 * 3. @AfterReturning 返回通知：目标对象的方法调用完成，在返回结果值之后触发
 * 4. @AfterThrowing 异常通知：目标对象的方法运行中抛出 / 触发异常后触发
 *    @AfterReturning 和 @AfterThrowing 会比 @After 先执行。
 * 5. @Around 环绕通知：编程式控制目标对象的方法调用
 *    同一个切面类中，环绕通知的执行时机在其他单个通知的「外层」
 */
@Aspect // 注册该类为切面类
@Component
public class Logger {
    // 切面通知注解使用：

    // 切面切入点定义接口时，会把接口所有实现类上的实现接口方法切入增强
    @Before("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void beforePrint() {
        System.out.println("Aspect @Before run ......");
    }

    @Before("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void beforePrintJoinPoint(JoinPoint joinPoint) {
        joinPoint.getTarget();
        joinPoint.getThis();
        joinPoint.getArgs();


        System.out.println("Aspect @Before + joinPoint run ......");
    }

    @AfterReturning("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void afterReturningPrint() {
        System.out.println("Aspect @AfterReturning run ......");
    }

    // @After 会在 @AfterReturning 和 @AfterThrowing 之后执行
    @After("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void afterPrint() {
        System.out.println("Aspect @After run ......");
    }

    @AfterThrowing("execution(public * com.learn._04_AOP_anno.service.FinanceService.*(..))")
    public void afterThrowingPrint() {
        System.out.println("Aspect @AfterThrowing run ......");
    }

    // 这个环绕通知的使用，可以很直观的理解「切面通知注解」在方法执行过程中的具体执行时机！
    @Around("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 类似于 @Before
        System.out.println("Aspect @Around before run ......");
        try {
            Object retVal = joinPoint.proceed();
            // 类似于 @AfterReturning
            System.out.println("Aspect @Around afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            // 类似于 @AfterThrowing
            System.out.println("Aspect @Around afterThrowing run ......");
            throw e;
        } finally {
            // 类似于 @After
            System.out.println("Aspect @Around after run ......");
        }
    }


    // 抽取通用切入点表达式：
    // @Pointcut + 切入点表达式 + 空方法
    @Pointcut("execution(public * com.learn._04_AOP_anno.service.FinanceService.*(..))")
    public void FinanceServiceMethodPointcut() {}

    // 使用通用切入点表达式：
    // 切面通知注解 + 通用切入点表达式所定义在的空方法
    @Before("FinanceServiceMethodPointcut()")
    public void beforeFinanceServiceMethodPrint() {
        System.out.println("Aspect @Before + @Pointcut run ......");
    }

    // 使用自定义注解替代切入点表达式，所有标记了 @Log 注解的方法将会被切入执行
    // 用法：@annotation(注解类全限定名)
    @After("@annotation(Log)")
    public void afterFinanceServiceMethodPrint() {
        System.out.println("Aspect @Log + @After run ......");
    }
}
