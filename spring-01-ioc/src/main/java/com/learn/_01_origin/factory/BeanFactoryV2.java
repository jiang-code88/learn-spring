package com.learn._01_origin.factory;

import com.learn._01_origin.dao.DemoDao;
import com.learn._01_origin.dao.impl.DemoOracleDaoImpl;

/**
 * V2 架构 Service 的 DemoDao 类静态工厂 BeanFactoryV2
 *  - 缺点：BeanFactoryV2 想要切换 Mysql 或 Oracle 的数据库操作类时都得修改代码，开发成本高。
 *    同时如果数据库操作类 DaoImpl 的数量繁多，如增加 DemoRedisDaoImpl、
 *    DemoMongoDBDaoImpl、DemoPGDaoImpl 等等，每次是否都要手动 new 十分繁琐，开发成本高。
 */
public class BeanFactoryV2 {

    // 使用静态工厂的静态方法来创建特定类型的实现类，
    // 当需要从 MysqlDao 修改为 OracleDao 时只需要修改该静态方法即可
    public static DemoDao getDemoDao(){
        return new DemoOracleDaoImpl();
    }

}
