package com.learn.config;

import com.learn.interceptor.DemoExtraHandlerInterceptor;
import com.learn.interceptor.DemoHandlerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.Duration;

/**
 * 子容器的配置类, 仅存放 Controller 的 bean 和视图解析器的 bean
 */

/* 方式一: */
// @Configuration
// @ComponentScan(value = "com.learn",
//                includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
//                useDefaultFilters = false)
// public class WebMvcConfiguration {
//     // 配置创建一个视图解析器的 bean
//     @Bean
//     public ViewResolver viewResolver(){
//         InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//         viewResolver.setPrefix("/WEB-INF/pages/");
//         viewResolver.setSuffix(".jsp");
//         return viewResolver;
//     }
// }


/* 方式二: */
@Configuration
// 开启 WebMvc 的配置
@EnableWebMvc
// 只扫描创建 @Controller 注解标记的 bean
@ComponentScan(value = "com.learn",
               includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
               useDefaultFilters = false)
public class EnableWebMvcConfiguration extends WebMvcConfigurerAdapter {
    // 方式一和方式二最大的不同:
    // 方法二对比方法一是使用 @EnableWebMvc 注解开启使用子容器的编程式配置, 而不再需要手动指定创建 bean 来使用
    // 只需要配置一下视图解析器即可，不需要创建一个视图解析器 bean 再指定 bean 的属性值
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        // 相对于方法一, 方法二可以快速配置基于 jsp 的视图解析
        viewResolverRegistry.jsp("/WEB-INF/pages/", ".jsp");
    }

    // 配置静态资源解析器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 指定拦截到静态资源请求时该去那个目录下找静态资源响应
        registry.addResourceHandler("/js/**").addResourceLocations("/js/")
                // 静态资源都会在浏览器中缓存，这样就不会每次请求时重复加载。
                // Spring-MVC 支持配置这些静态资源的缓存时长。
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(30)));
    }

    // 配置自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        DemoHandlerInterceptor interceptor = new DemoHandlerInterceptor();
        DemoExtraHandlerInterceptor extraInterceptor = new DemoExtraHandlerInterceptor();

        // 注册自定义的拦截器
        registry.addInterceptor(interceptor)
                // 配置拦截器要拦截的请求路径: /department/** 表示匹配路径及其子路径
                .addPathPatterns("/department/**");

        // 1. 有多个 handlerInterceptor 时先注册的拦截器先执行
        // 2. 有多个拦截器同时运行时, 只要拦截器的 preHandle() 方法返回 true,
        //    就能继续向下执行下一个拦截器的 preHandle(), 同时这个拦截器的 afterCompletion() 也会被调用。
        // 3. 只有所有拦截器的 preHandle() 方法返回值都为 true 时才会调用 Controller 和 postHandle() 方法
        registry.addInterceptor(extraInterceptor)
                .addPathPatterns("/department/**");

        /*
        多个拦截器的方法执行顺序:
         - preHandle() 是顺序执行的
            preHandle() DemoHandlerInterceptor
            preHandle() DemoExtraHandlerInterceptor
         - postHandle() 和 afterCompletion() 的执行是逆序的
            postHandle() DemoExtraHandlerInterceptor
            postHandle() DemoHandlerInterceptor
            afterCompletion() DemoExtraHandlerInterceptor
            afterCompletion() DemoHandlerInterceptor
        */
    }
}


