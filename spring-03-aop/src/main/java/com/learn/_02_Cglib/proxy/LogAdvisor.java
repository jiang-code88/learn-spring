package com.learn._02_Cglib.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class LogAdvisor implements MethodInterceptor {

    private Object target;
    private List<String> methods;

    public LogAdvisor(Object target, List<String> methods) {
        this.target = target;
        this.methods = methods;
    }

    @Override
    public Object intercept(Object proxy, Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        if (methods.contains(method.getName())){
            System.out.println(method.getName() + ": 666");
        }
        return method.invoke(target, args);
    }
}
