package com.learn.servlet;

import com.learn.service.DepartmentService;
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
 * 1. 该 Servlet 映射处理 /department 请求
 * 2. 在该 Servlet 初始化时，从服务器的 application 域中获取 IOC 容器，
 *    并配置 IOC 容器中的 bean 可以使用 @Autowired 自动注入。
 * 3. 重写 doGet() 方法处理 url 为 "/user" 的 get 请求
 */
@WebServlet(urlPatterns = "/department")
public class DepartmentServlet extends HttpServlet {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        // 配置使用 @Autowired 自动注入 IOC 容器的 bean，简化手动从容器拿出 bean
        SpringBeanAutowiringSupport.
                processInjectionBasedOnServletContext(this, servletContext);
    }

    // 处理 url 为 "/department" 的 get 请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String department = departmentService.getDepartment();
        resp.getWriter().println(department);
    }
}
