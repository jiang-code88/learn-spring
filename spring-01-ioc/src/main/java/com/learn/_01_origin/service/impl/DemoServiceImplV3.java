package com.learn._01_origin.service.impl;

import com.learn._01_origin.dao.DemoDao;
import com.learn._01_origin.factory.BeanFactoryV3;
import com.learn._01_origin.service.DemoService;

import java.util.List;

/**
 * 模拟使用 DemoDao 数据库操作类的 Service 层
 *
 * V3 架构 Service：BeanFactoryV3 的重构-引入反射实例化和外部配置文件
 */
public class DemoServiceImplV3 implements DemoService {

    private DemoDao demoDao = BeanFactoryV3.getDemoDao();

    @Override
    public List<String> findAll() {
        return this.demoDao.findAll();
    }
}
