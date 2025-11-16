package com.learn._04_AOP_anno.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * LoggerAspect 切面类和 TransactionAspect 切面类
 * 其中的切面方法都切入了 FinanceService.addMoney() 方法，
 * 通过 @Order 注解控制切面方法的执行顺序，值越小优先级越高。
 * 默认值是 Integer.MAX_VALUE 表示最后执行。
 *
 * 代理对象被调用的方法中又调用自身方法时，实际上调用的是原始对象的自身方法，
 * 不会被切面类的切面方法增强（AOP 失效），如果希望调用自身方法时调用的也是代理对象的方法，获得增强。
 * 那就需要在 service 类的方法内部使用 AopContext 获取当前类的代理对象，再通过代理对象来调用。
 * - 如果报错 java.lang.IllegalStateException: Cannot find current proxy: Set 'exposeProxy' property on Advised to 'true' to make it available, ...
 *   其实是该功能在 SpringAOP 中是默认关闭的，
 *   需要通过在 @EnableAspectJAutoProxy 注解上显式指定 exposeProxy 参数为 true 才能开启（默认是 false）。
 */
@Aspect
@Component
@Order(0)
public class TransactionAspect {
    @Before("execution(public * com.learn._04_AOP_anno.service.FinanceService.addMoney(..))")
    public void beforePrintOrder() {
        System.out.println("TransactionAspect @Before + @Order(First) run ......");
    }

    // 代理对象中的 updateMoneyById() 会调用自身类中的 getMoneyById() 方法
    //
    @Before("execution(public * com.learn._04_AOP_anno.service.FinanceService.updateMoneyById(..))")
    public void beforePrintAopContext() {
        System.out.println("TransactionAspect @Before + AopContext run ......");
    }
}
