package com.learn._00_origin.decorator;

import com.learn._00_origin.service.DemoService;

/**
 * 装饰器类与被装饰类实现相同的接口，通过委托的方式使用装饰器类代替被装饰类调用方法
 * 在装饰器类中负责日志逻辑，被委托类中只负责业务逻辑。
 * 优点：对比「手动日志」避免日志代码和业务逻辑代码耦合，难以维护；
 *      如日志等其他事务、参数校验等逻辑，可以通过叠加多个装饰器，反复装饰实现。
 * 缺点：不同的业务接口都要写一个装饰器来增强，例如 DemoService、UserService、
 *      DepartmentService 都得实现一个对应的装饰器来增加日志逻辑，代码会有冗余。
 */
public class DemoServiceLogDecorator implements DemoService {

    private DemoService target;

    // 装饰器构造方法中需要传入被修饰的原对象
    public DemoServiceLogDecorator(DemoService target){
        this.target = target;
    }

    @Override
    public int add(String userId, int points) {
        // 在原对象执行方法前通过装饰器打印日志，实现日志逻辑与业务逻辑解耦。
        System.out.println("decorator log DemoService add: " + points);
        return target.add(userId, points);
    }

    @Override
    public int subtract(String userId, int points) {
        // 在原对象执行方法前通过装饰器打印日志，实现日志逻辑与业务逻辑解耦。
        System.out.println("decorator log DemoService subtract: " + points);
        return target.add(userId, points);
    }

    @Override
    public int multiply(String userId, int points) {
        // 在原对象执行方法前通过装饰器打印日志，实现日志逻辑与业务逻辑解耦。
        System.out.println("decorator log DemoService multiply: " + points);
        return target.add(userId, points);
    }

    @Override
    public int divide(String userId, int points) {
        // 在原对象执行方法前通过装饰器打印日志，实现日志逻辑与业务逻辑解耦。
        System.out.println("decorator log DemoService divide: " + points);
        return target.add(userId, points);
    }
}
