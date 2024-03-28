package com.learn._04_advanced._05_eventListener.customEventLister.service;

import com.learn._04_advanced._05_eventListener.customEventLister.event.RegisterSuccessEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 定义事件发布器（事件广播器）
 *  - 自定义发布器中使用 IOC 容器的 ApplicationEventPublisher 在应用上下文中发布事件。
 *  - 实现 ApplicationEventPublisherAware 接口在 bean 实例化时，
 *     通过回调的方式注入 ApplicationEventPublisher 使用。
 */
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username){
        System.out.println(username + " 注册成功...");

        // 创建一个注册成功事件
        RegisterSuccessEvent event = new RegisterSuccessEvent(this);
        event.setUsername(username);

        // 发布注册成功事件
        applicationEventPublisher.publishEvent(event);
    }
}
