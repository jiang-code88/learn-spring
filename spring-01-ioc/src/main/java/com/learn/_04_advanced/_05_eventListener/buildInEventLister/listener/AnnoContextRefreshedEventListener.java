package com.learn._04_advanced._05_eventListener.buildInEventLister.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 自定义 Spring 内置事件监听器（使用 @EventListener 注解）
 */
@Component
public class AnnoContextRefreshedEventListener {
    // 监听 Spring 框架内置 ContextRefreshedEvent 事件
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println(
                "ContextRefreshApplicationListener 监听器(注解标记绑定的监听器), " +
                        "监听到 ContextRefreshedEvent 事件的发生");
    }
}
