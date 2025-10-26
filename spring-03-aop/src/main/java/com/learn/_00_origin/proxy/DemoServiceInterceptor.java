package com.learn._00_origin.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib 动态代理——基于字节码增强技术（基于继承通过子类生成代理对象）
 * 1. 被代理的类不能是 final，因为 Cglib 会动态创建代理类的子类，final 类型的类无法被继承。
 * 2. 被代理的类必须有默认的无参构造方法。
 * 3. 具体的代理逻辑就在 MethodInterceptor 的 intercept 方法中编写。
 * <p>
 * Jdk 原生动态代理和 Cglib 动态代理区别
 * 1. jdk 动态代理的代理对象创建速度快，执行速度慢；Cglib 动态代理的代理对象创建速度慢，执行速度快
 * 2. Cglib 没有 jdk 原生动态代理至少实现一个接口的限制，但是需要依赖第三方 Cglib 包。
 */
public class DemoServiceInterceptor implements MethodInterceptor {

    private Object target;

    public DemoServiceInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object proxy,  // 代理对象的引用
                            Method method, // 代理对象被调用的方法（Java标准反射的API）
                            Object[] args, // 代理对象被调用方法的参数列表
                            MethodProxy methodProxy // 代理对象被调用的方法（Cglib 提供，比Java反射调用速度更快）
    ) throws Throwable {
        System.out.println("cglib proxy log DemoService " + method.getName() + ": " + args[1]);

        // 方式1（最差）：反射方法调用，对被代理对象方法的反射调用，性能较差。
        // Object result = method.invoke(target, args);

        // 方式2（次佳）：cglib 方法调用，对被代理对象方法的 cglib 调用，性能比反射高。
        // 避免 methodProxy.invoke(proxy, args); 调用，会递归的调用代理类的方法，导致栈溢出。
        // Object result = methodProxy.invoke(target, args);

        // 方式3（最佳）：cglib 方法调用，调用代理对象 proxy 的父类也就是被代理对象的方法
        // 与方式2 功能一致，但是更推荐这种方式，写法不容易混淆导致递归调用代理类方法
        Object result = methodProxy.invokeSuper(proxy, args);

        return result;
    }
}
