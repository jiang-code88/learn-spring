package com.learn._00_origin;

import com.learn._00_origin.decorator.DemoServiceLogDecorator;
import com.learn._00_origin.proxy.DemoServiceHandler;
import com.learn._00_origin.proxy.DemoServiceInterceptor;
import com.learn._00_origin.service.DemoService;
import com.learn._00_origin.service.impl.DemoServiceImpl;
import com.learn._00_origin.service.impl.LogManualDemoServiceImpl;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class DemoController {

    public DemoService logManualDemoService;
    public DemoService demoServiceLogDecorator;
    public DemoService demoServiceJDKProxy;
    public DemoService demoServiceCglibProxy;


    public DemoController(){
        // 原对象中增加日志代码：手动日志使得方法执行增加日志打印
        logManualDemoService = new LogManualDemoServiceImpl();

        // 装饰原对象的装饰对象：装饰器日志使得方法执行增加日志打印
        demoServiceLogDecorator = new DemoServiceLogDecorator(new DemoServiceImpl());

        // JDK 原生动态代理，生成代理对象，使得方法执行增加日志打印
        DemoServiceImpl target = new DemoServiceImpl();
        demoServiceJDKProxy = (DemoService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 被代理的对象所属类的类加载器
                target.getClass().getInterfaces(),  // 被代理的对象所属类实现的接口
                new DemoServiceHandler(target)      // 代理的具体代码实现
        );

        // Cglib 动态代理，生成代理对象，使得方法执行增加日志打印
        demoServiceCglibProxy = (DemoService) Enhancer.create(
                DemoServiceImpl.class,             // 被代理对象的类型
                new DemoServiceInterceptor(target) // 代理的具体代码实现
        );
    }

    public static void main(String[] args) {
        DemoController controller = new DemoController();
        controller.logManualDemoService.add("user_manual", 100);
        controller.demoServiceLogDecorator.add("user_decorator", 100);
        controller.demoServiceJDKProxy.add("user_proxy", 100);
        controller.demoServiceCglibProxy.add("user_proxy", 100);
    }
}
