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

import java.util.Arrays;

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
 *
 * 注意：
 * 1. 同一个切面类中，如果有多个同一通知类型的切面方法都切入同一个方法时，它们的执行顺序是不确定的。
 */
@Aspect // 注册该类为切面类
@Component
public class LoggerAspect {
    // 切面通知注解使用：
    // 切面切入点定义接口时，会把接口所有实现类上的实现接口方法切入增强
    @Before("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void beforePrint() {
        System.out.println("Log Aspect @Before run ......");
    }

    @AfterReturning("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void afterReturningPrint() {
        System.out.println("Log Aspect @AfterReturning run ......");
    }

    // @After 会在 @AfterReturning 和 @AfterThrowing 之后执行
    @After("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public void afterPrint() {
        System.out.println("Log Aspect @After run ......");
    }

    @AfterThrowing("execution(public * com.learn._04_AOP_anno.service.FinanceService.subtractMoneyThrowException(..))")
    public void afterThrowingPrint() {
        System.out.println("Log Aspect @AfterThrowing run ......");
    }

    // 这个环绕通知的使用，可以很直观的理解「切面通知注解」在方法执行过程中的具体执行时机！
    @Around("execution(public * com.learn._04_AOP_anno.service.OrderService.*(..))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        // 类似于 @Before
        System.out.println("Log Aspect @Around before run ......");
        try {
            Object retVal = joinPoint.proceed();
            // 类似于 @AfterReturning
            System.out.println("Log Aspect @Around afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            // 类似于 @AfterThrowing
            System.out.println("Log Aspect @Around afterThrowing run ......");
            throw e;
        } finally {
            // 类似于 @After
            System.out.println("Log Aspect @Around after run ......");
        }
    }


    // 抽取通用切入点表达式：
    // @Pointcut + 切入点表达式 + 空方法
    @Pointcut("execution(public * com.learn._04_AOP_anno.service.FinanceService.addMoney(..))")
    public void FinanceServiceMethodPointcut() {
    }

    // 使用通用切入点表达式：
    // 切面通知注解 + 通用切入点表达式所定义在的空方法
    @Before("FinanceServiceMethodPointcut()")
    public void beforePrintPointcut() {
        System.out.println("Log Aspect @Before + @Pointcut run ......");
    }

    // 使用自定义注解替代切入点表达式，所有标记了 @Log 注解的方法将会被切入执行
    // 用法：@annotation(注解类全限定名)
    @After("@annotation(com.learn._04_AOP_anno.anno.Log)")
    public void afterPrintAnnotation() {
        System.out.println("Log Aspect @Log + @After run ......");
    }


    // 切面方法可以通过 JoinPoint 类型参数获取切入类和方法的信息。
    @Before("execution(public * com.learn._04_AOP_anno.service.FinanceService.getMoneyById(..))")
    public void beforePrintJoinPoint(JoinPoint joinPoint) {
        // 这两个打印的对象地址一样是因为代理对象只增强了原始对象的 equals 和 hashcode 方法，
        // 没有增强 toString 方法，代理对象调用的还是原始对象的 toString 方法
        System.out.println(" 被拦截的对象：" + joinPoint.getTarget()); // 未经过代理的原始对象
        System.out.println(" 被拦截对象的代理对象：" + joinPoint.getThis()); // 代理对象
        System.out.println(" 被拦截对象方法的参数：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println(" 被拦截对象方法的方法签名：" + joinPoint.getSignature());
        System.out.println(" 被拦截对象方法的方法名：" + joinPoint.getSignature().getName());

        System.out.println("Log Aspect @Before + joinPoint run ......");
    }

    // 切面方法获取切入方法的返回值
    @AfterReturning(value = "execution(public * com.learn._04_AOP_anno.service.FinanceService.getMoneyById(..))",
                    returning = "retVal")
    public void afterReturningPrintReturning(Object retVal) {
        System.out.println(" 被拦截对象方法的返回值：" + retVal);
        System.out.println("Log Aspect @AfterReturning + returning run ......");
    }

    // 切面方法获取切入方法抛出的异常
    @AfterThrowing(value = "execution(public * com.learn._04_AOP_anno.service.FinanceService.subtractMoneyThrowException(..))",
                   throwing = "exception")
    public void afterThrowingPrintThrowing(Exception exception) {
        System.out.println(" 被拦截对象方法抛出的异常：" + exception);
        System.out.println("Log Aspect @AfterThrowing + throwing run ......");
    }

}
