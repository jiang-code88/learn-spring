package com.learn._01_origin.factory;

import com.learn._01_origin.dao.DemoDao;

import java.io.IOException;
import java.util.Properties;

/**
 * V3 架构 Service 的 DemoDao 类静态工厂 BeanFactoryV3
 * - 引入外部配置文件 factory.properties 控制数据库操作类的切换，
 *   避免切换不同数据库时，无需修改代码只需修改配置文件即可。
 * - 数据库控制类通过「反射 + 类全限定名」的方式实例化对象使用，
 *   避免繁琐的手动 new 实例对象。
 * - 缺点：每次执行 getBean 方法每次获取的实例化对象都是创建的新对象，
 *   其实并不需要每次都创建新对象，可以创建一个每次复用的。
 */
public class BeanFactoryV3 {
    // 使用静态代码块初始化 properties，加载 factory.properties 文件
    private static Properties properties;
    static {
        properties = new Properties();
        try {
            // 必须使用类加载器读取 resource 文件夹下的配置文件
            properties.load(BeanFactoryV3.class.getClassLoader().getResourceAsStream("_01_origin/factory.properties"));
        } catch (IOException e) {
            // BeanFactory 类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }

    public static DemoDao getBean(String beanName){
        try {
            return (DemoDao) Class.forName(properties.getProperty(beanName)).newInstance();
        }catch (ClassNotFoundException e){
            throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("[" + beanName + "] instantiation error!", e);
        }
    }

    public static DemoDao getDemoDao(){
        // 从配置文件的 EnableDemoDaoName 配置项中获取，希望启用哪一个数据库操作类的 beanName
        String enableDemoDaoName = properties.getProperty("EnableDemoDaoName");
        // 通过 beanName 对象的全限定名，自动反射创建数据库操作类对象使用
        return getBean(enableDemoDaoName);
    }

}
