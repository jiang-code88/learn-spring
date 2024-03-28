package com.learn._01_origin.service.impl;

import com.learn._01_origin.factory.BeanFactory;
import com.learn._01_origin.service.DemoService;
import com.learn._01_origin.dao.DemoDao;

import java.util.List;

/**
 * 模拟使用 DemoDao 数据库操作类的 Service 层
 */
public class DemoServiceImpl implements DemoService {
    // 不再依赖代码中的 new 来实例化具体对象
    // DemoDao demoDao = new DemoMySQLDaoImpl();
    // 依赖 BeanFactory 来帮助我们创建和获取对象
    DemoDao demoDao = BeanFactory.getDemoDaoBean();

    @Override
    public List<String> findAll() {
        return this.demoDao.findAll();
    }
}
