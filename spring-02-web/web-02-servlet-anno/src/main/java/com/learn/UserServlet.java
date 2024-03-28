package com.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无需使用 web.xml 文件即可实现 IOC 容器并配置到 web 容器中。
 */
@WebServlet(urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 从 application 域（ServletContext）中取出 IOC 容器
        ServletContext servletContext = config.getServletContext();
        // 配置容器中 bean 自动注入
        SpringBeanAutowiringSupport
                .processInjectionBasedOnServletContext(this, servletContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = userService.get();
        resp.getWriter().println(user);
    }
}