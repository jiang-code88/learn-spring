package com.learn._02_xml._01_quickstart;

import com.learn._02_xml._01_quickstart.service.PetStoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * SpringFramework 官网提供的 quickstart 示例
 * - 使用配置文件容器类
 */
public class QuickStartApplication {
    public static void main(String[] args) {
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "_02_xml/_01_quickstart/services.xml",
                "_02_xml/_01_quickstart/daos.xml");

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
