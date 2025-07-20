package com.learn._03_anno._03_componentDependencyInject._05_inject_aware;

import com.learn._03_anno._03_componentDependencyInject._05_inject_aware.bean.AwareTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 回调注入：
 *  - 在一个使用 @Component 注解标记的 bean 被容器创建好后，
 *    可以通过实现 Aware 系列的回调接口，将一些特定的信息注入到 bean 中。
 *
 *  1. 回调注入 ApplicationContext 容器 bean 到我们创建的 bean 中
 *     方便我们的 bean 使用 context 容器进行一些操作。
 *  2. 回调注入 bean 的 beanName 到我们创建的 bean 中，
 *     方便我们的 bean 自己持有自己的 beanName 进行一些操作。
 */
public class AwareInjectApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                "com.learn._03_anno._03_componentDependencyInject._05_inject_aware.bean");
        // 1.回调注入容器类 ApplicationContext 的 bean 到 AwareTestBean 类型的 bean 的成员变量中
        // 2.回调注入 beanName 到 AwareTestBean 类型的 bean 的成员变量中
        AwareTestBean bean = context.getBean(AwareTestBean.class);

        // 3. 利用回调注入的 ApplicationContext 类型的 bean 打印容器中所有的 bean 的 beanName
        bean.printBeanNames();
        System.out.println("------------------------------------");

        // 3. 让创建的 bean 自己持有自己的 beanName
        System.out.println(bean.getBeanName());
        System.out.println("------------------------------------");
    }
}
