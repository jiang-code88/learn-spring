package com.learn._04_advanced._05_eventListener.customEventLister.event;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册成功事件
 */
public class RegisterSuccessEvent extends ApplicationEvent {

    private String username;

    public RegisterSuccessEvent(Object source) {
        super(source);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
