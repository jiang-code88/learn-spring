package com.learn._04_advanced._05_eventListener.customEventLister.listener;

import com.learn._04_advanced._05_eventListener.customEventLister.event.RegisterSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderListener {
    @EventListener
    public void onRegisterSuccess(RegisterSuccessEvent event) {
        System.out.println("监听到 \""+ event.getUsername() +"\" 用户注册成功，" +
                "发送消息(注解绑定)...");
    }
}
