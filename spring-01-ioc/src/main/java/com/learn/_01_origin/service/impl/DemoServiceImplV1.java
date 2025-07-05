package com.learn._01_origin.service.impl;

import com.learn._01_origin.dao.DemoDao;
import com.learn._01_origin.dao.impl.DemoMySQLDaoImpl;
import com.learn._01_origin.service.DemoService;

import java.util.List;

/**
 * 模拟使用 DemoDao 数据库操作类的 Service 层
 *
 * V1 架构 Service：通过 new 实例化 DemoDao 数据库操作类
 *  - 缺点：如果需要更换 Oracle 数据库的操作类，需要修改所有原来用到 MysqlDao 的
 *    ServiceImpl 中 new 的代码，改为 new OracleDao，
 *    如果 ServiceImpl 很多则开发工作量很大，维护成本高。
 */
public class DemoServiceImplV1 implements DemoService {

    private DemoDao demoDao = new DemoMySQLDaoImpl();

    @Override
    public List<String> findAll() {
        return this.demoDao.findAll();
    }
}
