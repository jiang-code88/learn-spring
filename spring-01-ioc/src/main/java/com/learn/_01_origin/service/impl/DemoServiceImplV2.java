package com.learn._01_origin.service.impl;

import com.learn._01_origin.dao.DemoDao;
import com.learn._01_origin.factory.BeanFactoryV2;
import com.learn._01_origin.service.DemoService;

import java.util.List;

/**
 * 模拟使用 DemoDao 数据库操作类的 Service 层
 *
 * V2 架构 Service：通过静态工厂 BeanFactoryV1 的 getDemoDao 静态方法获取数据库操作类的实现类
 *  - 对比 V1 架构的优点：即使 ServiceImpl 数量再多，需要从 MysqlDao 变更为 OracleDao 时
 *    只需要修改静态工厂的静态方法即可。
 */
public class DemoServiceImplV2 implements DemoService {

    private DemoDao demoDao = BeanFactoryV2.getDemoDao();

    @Override
    public List<String> findAll() {
        return this.demoDao.findAll();
    }
}
