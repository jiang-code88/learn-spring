package com.learn._04_advanced._05_eventListener.customEventLister.listener;

import com.learn._04_advanced._05_eventListener.customEventLister.event.RegisterSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(-1) // 最先发送短信通知
public class SmsSenderListener implements ApplicationListener<RegisterSuccessEvent> {
    @Override
    public void onApplicationEvent(RegisterSuccessEvent event) {
        System.out.println("监听到 \""+ event.getUsername() +"\" 用户注册成功，" +
                "发送短信(实现接口绑定)...");
    }
}
