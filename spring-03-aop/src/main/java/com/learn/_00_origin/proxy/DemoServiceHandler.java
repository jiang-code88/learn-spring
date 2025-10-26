package com.learn._00_origin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk 原生动态代理（基于接口通过接口实现类生成代理对象）
 * 1. 要求被代理的对象所属类必须实现一个或以上的接口
 * 2. 具体的代理逻辑就在 InvocationHandler 的 invoke 方法中编写。
 *
 * 通过 JDK 原生动态代理机制，生成对象的代理对象，通过代理对象调用对象的方法
 * 也就是代理对象的方法调用会先执行代理对象的增强逻辑然后才调用到对象的方法。
 *
 * 缺点：被代理对象必须得要实现接口，因为代理对象需要实现和被代理对象相同的接口，
 * 优点：不修改原始代码的前提下，对已有任意代码的功能增强，同时能实现针对相同增强逻辑的扩展和抽取。
 */
public class DemoServiceHandler implements InvocationHandler {
    // 被代理对象
    private Object target;
    // 通过构造方法使得代理对象持有被代理对象
    public DemoServiceHandler(Object target) {
        this.target = target;
    }

    // 定义代理对象在「被代理对象 -> 被代理对象被调用方法 + 被代理对象调用方法参数」的过程中增加日志逻辑。
    // 调用 被代理对象的每一个方法时 都会走该方法先执行代理逻辑，然后再调用被代理对象的方法。
    @Override
    public Object invoke(Object proxy,  // 代理对象的引用
                         Method method, // 代理对象被调用的方法
                         Object[] args  // 代理对象被调用方法的参数列表
    ) throws Throwable {
        System.out.println("jdk proxy log DemoService " + method.getName() + ": " + args[1]);
        return method.invoke(target, args);
    }
}
