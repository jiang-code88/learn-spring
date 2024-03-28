package com.learn._03_anno._03_inject._04_inject_resource;

import com.learn._03_anno._03_inject._04_inject_resource.resourceBean.Birdcage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用 @Resource 注解实现自动注入
 *  - @Resource 注解相当于标注 @Autowired 和 @Qualifier
 *  - 如果找不到，也将使用类型匹配注入
 */
public class ResourceInjectApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._03_anno._03_inject._04_inject_resource.resourceBean");

        Birdcage bean = context.getBean(Birdcage.class);
        System.out.println(bean);
    }
}
