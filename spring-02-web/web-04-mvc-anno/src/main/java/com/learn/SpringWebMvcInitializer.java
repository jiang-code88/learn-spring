package com.learn;

import com.learn.config.RootConfiguration;
import com.learn.config.WebMvcConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 替换 web.xml 文件配置部署创建 IOC 容器
 * spring-mvc 设计了两个容器：根容器 和 servlet 子容器
 *  - 把 Service、Dao 等公用的类都放到根容器中实例化为 bean
 *  - 把 Controller 及相关的组件都放到 Servlet 的子容器中实例化为 bean
 * 父子容器的用意:
 *  1. 形成层级关系后, Controller 可以拿到 Service, 而 Service 拿不到 Controller, 实现隔离
 *  2. 如果具有多套 DispatcherServlet, 不必注册多套 Service 和 Dao,
 *     每个 Servlet 子容器都从这一个根容器中取 Service 和 Dao 即可
 * 父子容器的注意事项:
 *  - 在进行包扫描的时候，Servlet 子容器只能扫描 @Controller 注解, 而不能扫描 @Service、@Repository 等注解,
 *    否则会导致子容器中存在 Service 就不会去父容器中寻找, 从而引发一些问题（如事务失效、AOP 增强失效等）
 */
public class SpringWebMvcInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    // 配置根容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    // 配置子容器的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfiguration.class};
    }

    // 配置 DispatchServlet 的请求拦截
    //
    @Override
    protected String[] getServletMappings() {
        // 拦截处理所有请求、静态资源、但不拦截 .jsp
        return new String[]{"/"};
    }
}
