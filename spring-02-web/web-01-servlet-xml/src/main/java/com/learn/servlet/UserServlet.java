package com.learn.servlet;

import com.learn.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 该 Servlet 映射处理 /user 请求
 * 2. 在该 Servlet 初始化时，从服务器的 application 域中获取 IOC 容器，
 *    并从 IOC 容器中手动获取 service 的 bean 使用。
 * 3. 重写 doGet() 方法处理 url 为 "/user" 的 get 请求
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 从 ServletConfig 中获取 ServletContext
        ServletContext servletContext = config.getServletContext();
        // 使用 spring-web 提供的工具类从 ServletContext 中获取 IOC 容器
        WebApplicationContext ctx = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);
        // 从 IOC 容器中获取 bean, 并使用成员变量保存该 bean
        this.userService = ctx.getBean(UserService.class);
    }

    // 处理 url 为 "/user" 的 get 请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = userService.get();
        resp.getWriter().println(user);
    }
}