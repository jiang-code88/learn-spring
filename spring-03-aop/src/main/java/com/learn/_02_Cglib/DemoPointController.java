package com.learn._02_Cglib;

import com.learn._02_Cglib.proxy.LogAdvisor;
import com.learn._02_Cglib.service.DemoPointService;
import net.sf.cglib.proxy.Enhancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Cglib 动态代理——基于字节码增强技术（基于继承通过子类生成代理对象）
 *  1. 被代理的类不能是 final，因为 Cglib 会动态创建代理类的子类，final 类型的类无法被继承。
 *  2. 被代理的类必须有默认的无参构造方法。
 *  3. 具体的代理逻辑就在 MethodInterceptor 的 intercept 方法中编写。
 *
 * Jdk 原生动态代理和 Cglib 动态代理区别
 *  1. jdk 动态代理的代理对象创建速度快，执行速度慢；Cglib 动态代理的代理对象创建速度慢，执行速度快
 *  2. Cglib 没有 jdk 原生动态代理至少实现一个接口的限制，但是需要依赖第三方 Cglib 包。
 *
 */
public class DemoPointController {

    private DemoPointService demoPointService;

    public void init(){
        DemoPointService demoPointService = new DemoPointService();
        List<String> methods = new ArrayList<>();
        methods.add("add");
        methods.add("multiply");
        LogAdvisor logAdvisor = new LogAdvisor(demoPointService, methods);
        // 使用 Gglib 生成动态代理对象
        this.demoPointService = (DemoPointService) Enhancer
                .create(DemoPointService.class, logAdvisor);
    }

    public DemoPointController() {
        this.init();
    }

    public int add(String userId, int points){
        return this.demoPointService.add(userId, points);
    }

    public int subtract(String userId, int points){
        return this.demoPointService.subtract(userId, points);
    }

    public int multiply(String userId, int points){
        return this.demoPointService.multiply(userId, points);
    }

    public int divide(String userId, int points){
        return this.demoPointService.divide(userId, points);
    }

    public static void main(String[] args) {
        DemoPointController demoPointController = new DemoPointController();
        demoPointController.add("1", 100);
        demoPointController.subtract("2", 200);
        demoPointController.multiply("3", 300);
        demoPointController.divide("4", 400);
    }


}
