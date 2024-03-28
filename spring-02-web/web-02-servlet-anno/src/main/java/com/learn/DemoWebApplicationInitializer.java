package com.learn;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 这个类相当于 web.xml 部署配置文件的替代品：
 * web 应用（容器）启动时将调用 createRootApplicationContext 方法,
 * 加载其中创建的 IOC 容器放到 application 域中（ServletContext）
 */
public class DemoWebApplicationInitializer extends AbstractContextLoaderInitializer {
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // 实例化 AnnotationConfigWebApplicationContext 创建一个 IOC 容器
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        // IOC 容器手动读取 UserConfiguration 配置类, 创建 bean 放入容器中
        context.register(UserConfiguration.class);
        return context;
    }
}
