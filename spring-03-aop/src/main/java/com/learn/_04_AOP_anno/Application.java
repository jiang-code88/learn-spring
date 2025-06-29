package com.learn._04_AOP_anno;

import com.learn._04_AOP_anno.conf.AspectJAOPConfiguration;
import com.learn._04_AOP_anno.service.FinanceService;
import com.learn._04_AOP_anno.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注解式配置 AOP（其实是整合 AspectJ 实现的）
 *  - Before 前置通知：目标对象的方法调用之前触发
 *  - After 后置通知：目标对象的方法调用之后触发
 *  - AfterReturning 返回通知：目标对象的方法调用完成，在返回结果值之后触发
 *  - AfterThrowing 异常通知：目标对象的方法运行中抛出 / 触发异常后触发
 *  - Around 环绕通知：编程式控制目标对象的方法调用
 *
 *  环绕通知：同一个切面类中，环绕通知的执行时机比单个通知要早发生。
 *
 *  使用 @annotation 结合自定义注解 @Log 替换切入点表达式。
 *   - 使用 @annotation 声明的切入点表达式会搜索整个 IOC 容器中标注了 @Log 注解的所有 bean 方法进行增强。
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AspectJAOPConfiguration.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrder();
        System.out.println("---------------------");
        FinanceService financeService = context.getBean(FinanceService.class);
        financeService.addMoney(123.23);
        financeService.getMoneyById("abc");
        financeService.subtractMoney(234.45);
    }
}
