package com.learn._04_AOP_anno.aop;

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
 * 切面类
 */
@Component
@Aspect
public class Logger {

    // 定义空方法，定义可复用的切入点
    @Pointcut("execution(public void com.learn._04_AOP_anno.service.FinanceService.addMoney(double))")
    public void defaultPointcut() {
    }

    @Before("defaultPointcut()")
    public void beforePrint() {
        System.out.println("Logger beforePrint run ......");
    }

    @After("defaultPointcut()")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    @AfterReturning("@annotation(com.learn._04_AOP_anno.aop.Log)")
    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }

    @AfterThrowing("execution(public double com.learn._04_AOP_anno.service.FinanceService.subtractMoney(double))")
    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }

    @Around("execution(public double com.learn._04_AOP_anno.service.FinanceService.getMoneyById(String))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }
}
