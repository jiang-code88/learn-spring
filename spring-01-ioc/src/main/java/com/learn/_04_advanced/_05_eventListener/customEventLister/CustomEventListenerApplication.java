package com.learn._04_advanced._05_eventListener.customEventLister;

import com.learn._04_advanced._05_eventListener.customEventLister.service.RegisterService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自定义事件发布和监听
 *
 * 需求：
 *  用户注册成功时, 发布用户注册成功事件（事件携带用户名）,
 *  发送短信/邮件/消息的监听器，监听事件并执行相应操作。
 * 类结构：
 *  - 事件: RegisterSuccessEvent
 *  - 事件广播器: RegisterService(使用容器的 ApplicationEventPublisher 在应用上下文发布事件)
 *  - 监听器：
 *    - 邮件监听器（注解实现） EmailSenderListener   order() 最后执行
 *    - 消息监听器（注解实现） MessageSenderListener
 *    - 短信监听器（接口实现） SmsSenderListener     order(-1) 最先执行
 *
 * 使用 @Order 注解标记可以改变监听器的执行顺序
 *   - @Order 可以标记到类和方法上, @Order() 括号中指定的数值越小,
 *     方法的执行优先级越高(可以填负数, 最大值为 Integer.MAX_VALUE)
 *   - @Order 注解的默认数值为 Integer.MAX_VALUE, 表示最后执行
 *   - 标记 @Order(-1) 表示该方法最先执行。
 *   - 不标记 @Order 方法的数值是 0, 且「注解绑定的监听器」比「接口绑定的监听器」先触发执行
 */
public class CustomEventListenerApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._04_advance._05_eventListener.customEventLister");

        // 获取事件广播器，广播一个 username 为 "John" 的事件
        RegisterService registerService = context.getBean(RegisterService.class);
        registerService.register("John");
    }
}
