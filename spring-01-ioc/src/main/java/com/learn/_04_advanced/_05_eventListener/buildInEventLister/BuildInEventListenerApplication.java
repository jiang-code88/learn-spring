package com.learn._04_advanced._05_eventListener.buildInEventLister;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 的事件监听机制（观察者设计模式在 Spring 中的实现）
 *  - 模型：事件源(事件) ==观察==> 事件广播器(观察者) ==绑定==> 监听器(订阅者)
 *  - IOC 容器本身就是事件广播器, 是观察者
 *
 * Spring 默认内置事件（可以使用监听器默认监听 IOC 容器的以下事件）:
 *  - ContextRefreshedEvent 事件, 表示 "容器刷新完毕（所有单实例 Bean 刚创建完成）" 事件, 触发于 "IOC 容器刷新完毕但尚未启动时"
 *  - ContextClosedEvent 事件, 表示 "容器即将关闭" 事件, 触发于 "IOC 容器已经关闭但尚未销毁所有 Bean 时"
 *  - ContextStartedEvent 事件, 表示 "容器启动完毕" 事件,
 *    触发于 "ContextRefreshedEvent 触发后 + 所有实现了 Lifecycle 接口的 Bean 执行回调 start 方法后"
 *  - ContextStoppedEvent 事件, 表示 "容器关闭完毕" 事件, 触发于 "ContextClosedEvent 触发之后"
 *
 * 使用「注解绑定的监听器」比「实现接口绑定的监听器」先触发执行
 */
public class BuildInEventListenerApplication {
    public static void main(String[] args) {
        System.out.println("IOC 容器准备初始化...");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._04_advanced._05_eventListener.buildInEventLister.listener");
        System.out.println("IOC 容器初始化完成...");

        System.out.println("\n---------------------------------------------\n");

        System.out.println("IOC 容器准备销毁...");
        context.close();
        System.out.println("IOC 容器销毁完成...");
    }
}
