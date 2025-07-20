package com.learn._02_xml._01_quickstart;

import com.learn._02_xml._01_quickstart.service.PetStoreService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * SpringFramework 官网提供的 quickstart 示例
 *  - 使用兼容容器类
 */
public class GenericApplication {
    public static void main(String[] args) {
        /*
            Such reader delegates can be mixed and matched on the same ApplicationContext,
            reading bean definitions from diverse configuration sources, if desired.
         */
        GenericApplicationContext context = new GenericApplicationContext();

        new XmlBeanDefinitionReader(context).loadBeanDefinitions(
                "_02_xml/_01_quickstart/services.xml",
                "_02_xml/_01_quickstart/daos.xml");
        context.refresh();

        // retrieve configured instance
        PetStoreService service =
                context.getBean("petStore", PetStoreService.class);

        // use configured instance
        List<String> userList = service.getUsernameList();
        userList.forEach(System.out::println);

        List<String> itemNameList = service.getItemNameList();
        itemNameList.forEach(System.out::println);
    }
}
