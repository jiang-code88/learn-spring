package com.learn._03_anno._03_componentDependencyInject._04_inject_resource;

import com.learn._03_anno._03_componentDependencyInject._04_inject_resource.conf.ResourceInjectConfiguration;
import com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean.Bird;
import com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean.BirdTigerInject;
import com.learn._03_anno._03_componentDependencyInject._04_inject_resource.resourceBean.Tiger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用 @Resource 注解实现自动注入
 *  - @Resource 也是用来属性注入的注解，它与 @Autowired 的不同之处在于：
 *     - @Autowired 是首先按照类型注入，然后经过 @Qualifier、@Primary，
 *       最后拿成员变量名和 bean 名称匹配注入。
 *     - 而 @Resource 是首先按照成员变量名匹配 Bean 名称注入，
 *       找不到再用类型匹配注入（相同类型的多个 bean 也会报错）
 */
public class ResourceInjectApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                ResourceInjectConfiguration.class);

        // 容器中存在一个 Bird 类型的 bean 名为 bird1
        Tiger tiger1 = context.getBean("tiger1", Tiger.class);
        System.out.println(tiger1);

        // 容器中存在一个 Bird 类型的 bean 名为 bird1
        Bird bird1 = context.getBean("bird1", Bird.class);
        System.out.println(bird1);

        // 容器中存在一个 Bird 类型的 bean 名为 bird2
        Bird bird2 = context.getBean("bird2", Bird.class);
        System.out.println(bird2);

        BirdTigerInject birdTigerInject =
                context.getBean(BirdTigerInject.class);
        System.out.println(birdTigerInject);
    }
}
