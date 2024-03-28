package com.learn._01_origin.factory;

import com.learn._01_origin.dao.DemoDao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BeanFactory {
    private static Properties properties;

    // 实例缓存，缓存已经创建好的实例对象
    private static Map<String, DemoDao> objectMap = new HashMap<>();

    // 使用静态代码块初始化 properties，加载 factory.properties 文件
    static {
        properties = new Properties();
        try {
            // 必须使用类加载器读取 resource 文件夹下的配置文件
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("_01_origin/factory.properties"));
        } catch (IOException e) {
            // BeanFactory 类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    public static DemoDao getBean(String beanName){
        // 双重检验创建单例对象保证 beanMap 中只创建一个 beanName 对应的实例对象
        if(!objectMap.containsKey(beanName)){
            synchronized (BeanFactory.class){
                if(!objectMap.containsKey(beanName)){
                    try {
                        // 从 properties 文件中读取指定 name 对应类的全限定名，并反射实例化
                        DemoDao demoDao = (DemoDao) Class.forName((String) properties.get(beanName)).newInstance();
                        objectMap.put(beanName, demoDao);
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

    public static DemoDao getDemoDaoBean(){
        String daoName = properties.getProperty("daoName");
        return getBean(daoName);
    }
}
