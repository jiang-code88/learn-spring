package com.learn._01_origin.service.impl;

import com.learn._01_origin.dao.DemoDao;
import com.learn._01_origin.factory.BeanFactoryV4;
import com.learn._01_origin.service.DemoService;

import java.util.List;

/**
 * 模拟使用 DemoDao 数据库操作类的 Service 层
 *
 * V4 架构 Service：BeanFactoryV4 的重构-引入对象缓存
 */
public class DemoServiceImplV4 implements DemoService {

    private DemoDao demoDao = BeanFactoryV4.getDemoDao();

    @Override
    public List<String> findAll() {
        return this.demoDao.findAll();
    }
}
