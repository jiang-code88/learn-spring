package com.learn._01_origin.dao.impl;

import com.learn._01_origin.dao.DemoDao;

import java.util.Arrays;
import java.util.List;

/**
 * 模拟访问 Oracle 数据库的操作类
 */
public class DemoOracleDaoImpl implements DemoDao {
    @Override
    public List<String> findAll() {
        // 模拟返回数据库中获取的数据
        return Arrays.asList("oracle", "oracle", "oracle");
    }
}
