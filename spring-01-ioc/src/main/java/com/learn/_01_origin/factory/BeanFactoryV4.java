package com.learn._01_origin.factory;

import com.learn._01_origin.dao.DemoDao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * V4 架构 Service 的 DemoDao 类静态工厂 BeanFactoryV4
 * - 引入对象缓存，缓存已创建的实例对象，避免每次获取时都去创建一个，降低系统的资源消耗。
 */
public class BeanFactoryV4 {
    // 使用静态代码块初始化 properties，加载 factory.properties 文件
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            // 必须使用类加载器读取 resource 文件夹下的配置文件
            properties.load(BeanFactoryV4.class.getClassLoader().getResourceAsStream("_01_origin/factory.properties"));
        } catch (IOException e) {
            // BeanFactory 类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    // 实例缓存，缓存已经创建好的实例对象
    private static Map<String, DemoDao> objectMap = new HashMap<>();
    public static DemoDao getBean(String beanName) {
        // 双重检验创建单例对象每个 beanName 对应的实例对象只被实例化一次。
        if (!objectMap.containsKey(beanName)) {
            synchronized (BeanFactoryV4.class) {
                if (!objectMap.containsKey(beanName)) {
                    try {
                        DemoDao bean = (DemoDao) Class.forName(properties.getProperty(beanName)).newInstance();
                        objectMap.put(beanName, bean);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException("[" + beanName + "] instantiation error!", e);
                    }
                }

            }
        }
        return objectMap.get(beanName);
    }

    public static DemoDao getDemoDao() {
        // 从配置文件的 EnableDemoDaoName 配置项中获取，希望启用哪一个数据库操作类的 beanName
        String enableDemoDaoName = properties.getProperty("EnableDemoDaoName");
        // 通过 beanName 对象的全限定名，自动反射创建数据库操作类对象使用
        return getBean(enableDemoDaoName);
    }

}
