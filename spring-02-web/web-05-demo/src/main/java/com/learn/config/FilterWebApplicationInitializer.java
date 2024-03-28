package com.learn.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * 浏览器提交表单时, 字符编码集和后端 Tomcat 的编码集不一致时, 使用该过滤器指定使用 UTF-8 编码解析
 */
public class FilterWebApplicationInitializer implements WebApplicationInitializer {

    /**
     * 浏览器提交表单时, 并不会发送带 content-type 请求头的字符编码标识符,
     * 而是会把字符编码的决定留在读取 HTTP 请求的时候。
     * 如果此时浏览器没有指明字符编码集,
     * Web 容器（Tomcat）创建请求, 读和解析 POST 表单数据的时候,
     * 默认使用的编码是 "ISO-8859-1" 所以就会造成显示乱码的情况。
     *
     * 增加配置一个 Filter (使用 UTF-8 解析) 就可以避免 post 请求使用 "ISO-8859-1" 编码集解析出乱码。
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration.Dynamic filter = servletContext.addFilter(
                "characterEncodingFilter", CharacterEncodingFilter.class);
        filter.addMappingForUrlPatterns(
                EnumSet.of(DispatcherType.REQUEST), true, "/*");
        filter.setInitParameter("encoding", "UTF-8");
    }
}
