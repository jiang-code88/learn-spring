package com.learn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义实现 Spring-MVC 提供的拦截器逻辑
 */
public class DemoHandlerInterceptor implements HandlerInterceptor {

    // 切入时机: 在执行 Controller 的方法之前触发, 可用于编解码、权限校验拦截等
    //  - 默认返回 true
    //  - 返回 false 表示 Controller 方法, 以及下面的 postHandler 和 afterHandler 方法都不会执行。
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle() DemoHandlerInterceptor");
        return true;
    }

    // 切入时机: 在执行完 Controller 方法后, 跳转页面 / 返回 Json 格式数据之前触发, 可以对请求的数据和视图进行修改
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle() DemoHandlerInterceptor");
    }

    // 切入时机: 在完全执行完 Controller 方法后触发。Controller 执行抛出异常时也会触发到这个拦截器
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("afterCompletion() DemoHandlerInterceptor");
    }

}
