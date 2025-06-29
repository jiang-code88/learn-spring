package com.learn._03_AOP_xml;

import com.learn._03_AOP_xml.service.FinanceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1 AOP 术语
 *  - Target 目标对象
 *  - Proxy 代理对象
 *  - JoinPoint 连接点（目标对象类中定义的所有方法）
 *  - Pointcut 切入点（切入点可以是 0 个或多个（甚至全部）连接点的组合）
 *  - Advice 通知（在连接点的切入点上增强的逻辑代码）
 *  - Weaving 织入（将 Advice 通知应用到 Target 目标对象，进而生成 Proxy 代理对象的过程）
 *
 *  Proxy 代理对象 = Target 目标对象 + Advice 通知
 *  Aspect 切面 = PointCut 切入点 + Advice 通知
 *
 * 2 通知类型
 *  - Before 前置通知：目标对象的方法调用之前触发
 *  - After 后置通知：目标对象的方法调用之后触发
 *  - AfterReturning 返回通知：目标对象的方法调用完成，在返回结果值之后触发
 *  - AfterThrowing 异常通知：目标对象的方法运行中抛出 / 触发异常后触发
 *    AfterReturning 与 AfterThrowing 两者互斥
 *    如果方法调用成功无异常，则会有返回值；如果方法抛出了异常，则不会有返回值。
 *  - Around 环绕通知：编程式控制目标对象的方法调用，可以直接拿到目标对象，以及要执行的方法。
 *    环绕通知可以任意的在目标对象的方法调用前后搞事，甚至不调用目标对象的方法。
 *    编写 InvocationHandler 或 MethodInterceptor 的匿名内部类就是实现环绕通知。
 *
 * 3 基于 XML 的 AOP 实现
 *  - IOC 容器配置文件 xmlaspect.xml
 *  - 在 xmlaspect.xml 中定义切面、定义通知类型、定义切入点表达式
 *
 * 4 切入点表达式
 *  - execution(
 *   - public 限定只切入 public 类型的方法
 *   - void 限定只切入返回类型为 void 的方法
 *   - 限定切入方法类全限定名
 *   - 限定切入方法名
 *   - 限定只切入方法的参数列表类型：对于基本数据类型，直接声明即可；引用数据类型则要写类的全限定名
 *  - )
 *
 * 5 切入点表达式通配符
 *  - 基本通配符 * 表示不限制。
 *  - 如果通配符 * 覆盖到接口类，则这个接口的所有实现类上的匹配方法都会被切入增强。
 *  - 如果通配符 * 使用在方法参数上，表示切入任意类型的单个参数方法，不匹配没有参数，或多个参数。
 *    使用通配符 .. 表示匹配不限参数类型和参数个数（可以没有参数）。
 *  - 如果通配符使用在包名中，* 表示单个包，.. 表示多个包。
 *  - public 访问修饰符不写的话，表示切入所有访问修饰符的方法。
 *  - 抛出异常的切入，如果方法参数后有用 throws 抛出异常的，切入表达式可以写上 throws 和抛出的类型全限定名
 */
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("xmlaspect.xml");
        FinanceService financeService = applicationContext
                .getBean(FinanceService.class);
        financeService.addMoney(123.23);
        financeService.subtractMoney(234.45);
        financeService.getMoneyById("abc");
    }
}
