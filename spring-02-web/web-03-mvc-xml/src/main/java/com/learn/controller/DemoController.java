package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基于 web.xml 形式搭建的 spring-mvc 工程
 * 需求：实现需求: 当浏览器请求 /demo 时，能给你跳转到 demo.jsp 页面
 *
 * - 需要额外引入一个 "视图解析器" 组件,
 *   他的作用是将上面 Controller 中返回的页面相对路径字符串解析为实际的 jsp 页面
 */
@Controller
public class DemoController {
    // @RequestMapping 注解用于指定要监听的请求 uri
    @RequestMapping("/demo")
    public String demo(){
        // 方法的返回值代表要跳转页面的相对路径(无需加 .jsp 的后缀)
        return "demo";
    }
}
