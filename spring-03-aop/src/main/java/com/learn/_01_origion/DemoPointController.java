package com.learn._01_origion;

import com.learn._01_origion.proxy.LogAdvisor;
import com.learn._01_origion.service.DemoPointService;
import com.learn._01_origion.service.impl.DemoPointServiceImpl;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * jdk 原生动态代理（基于接口通过接口实现类生成代理对象）
 * 1. 要求被代理的对象所属类必须实现一个以上的接口
 * 2. 具体的代理逻辑就在 InvocationHandler 的 invoke 方法中编写。
 */
public class DemoPointController {

    private DemoPointService demoPointService;

    public void init(){
        // 创建被代理对象
        DemoPointService demoPointService = new DemoPointServiceImpl();
        Class<? extends DemoPointService> clazz = demoPointService.getClass();
        // 使用 jdk 原生动态代理，生成代理对象
        this.demoPointService = (DemoPointService) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(method.getName() + ": 666");
                    return method.invoke(demoPointService, args);
                });
    }

    public void init_AOP(){
        DemoPointService demoPointService = new DemoPointServiceImpl();
        List<String> methods = new ArrayList<>();
        methods.add("subtract");
        methods.add("divide");
        LogAdvisor logAdvisor = new LogAdvisor(demoPointService, methods);
        this.demoPointService = (DemoPointService) Proxy.newProxyInstance(
                demoPointService.getClass().getClassLoader(),
                demoPointService.getClass().getInterfaces(),
                logAdvisor
        );
    }

    public DemoPointController() {
        // this.init();
        this.init_AOP();
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
