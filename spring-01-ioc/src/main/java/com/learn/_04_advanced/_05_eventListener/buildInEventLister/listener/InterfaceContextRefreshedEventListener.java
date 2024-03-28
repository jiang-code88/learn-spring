package com.learn._04_advanced._05_eventListener.buildInEventLister.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 自定义 Spring 内置事件监听器（实现 ApplicationListener 接口）
 *  - 通过 ApplicationListener 接口的范型，定义监听的事件。
 */
@Component
public class InterfaceContextRefreshedEventListener
        implements ApplicationListener<ContextRefreshedEvent> {
    // 监听 Spring 框架内置 ContextRefreshedEvent 事件
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(
                "ContextRefreshApplicationListener 监听器(实现接口绑定的监听器), " +
                        "监听到 ContextRefreshedEvent 事件的发生");
    }
}
