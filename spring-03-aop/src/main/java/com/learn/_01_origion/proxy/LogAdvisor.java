package com.learn._01_origion.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class LogAdvisor implements InvocationHandler {

    private Object target;
    private List<String> methods;

    public LogAdvisor(Object target, List<String> methods) {
        this.target = target;
        this.methods = methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (methods.contains(method.getName())){
            System.out.println(method.getName() + ": 666");
        }
        return method.invoke(target, args);
    }
}
