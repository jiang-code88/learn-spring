package com.learn.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Spring-MVC 的异常处理类
 *  - @ControllerAdvice 的本质是一个 @Component,
 *    它专门用于给多个标注了 @Controller 注解的类,
 *    共享标注有 @ExceptionHandler, @InitBinder 或 @ModelAttribute 的方法。
 */
@ControllerAdvice // 该注解用于增强所其他 @Controller 注解标记的类(默认所有), 使得他们增加拥有该类提供的异常处理功能
public class CustomExceptionHandler {

    /**
     * 处理 RuntimeException 异常的方法
     * - @ExceptionHandler 注解的 value 属性指定要捕获的异常类型
     */
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(HttpServletRequest request, RuntimeException e){
        // request 和 response 是抛出异常的请求和响应对象
        // e 是具体的异常对象
        e.printStackTrace();
        request.setAttribute("message", e.getMessage());
        return "error"; // 视图解析为 /WEB-INF/pages/error.jsp
    }

    /**
     * 处理 IllegalArgumentException 异常的方法
     * - @ExceptionHandler 注解的 value 属性指定要捕获的异常类型
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(HttpServletRequest request, RuntimeException e){
        // request 和 response 是抛出异常的请求和响应对象
        // e 是具体的异常对象
        e.printStackTrace();
        request.setAttribute("message", e.getMessage());
        return "error";
    }
}
