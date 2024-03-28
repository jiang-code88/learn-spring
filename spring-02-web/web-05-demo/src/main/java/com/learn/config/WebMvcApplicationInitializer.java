package com.learn.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{EnableWebMvcConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 拦截处理所有请求、静态资源、但不拦截 .jsp
        return new String[]{"/"};
    }
}
