package com.learn._00_origin.service.impl;

import com.learn._00_origin.service.DemoService;

/**
 * DemoService 实现类中通过「手动打日志」的方式在接口方法实现中打印日志。
 * 缺点：日志代码和方法实现代码耦合！！！
 */
public class LogManualDemoServiceImpl implements DemoService {
    @Override
    public int add(String userId, int points) {
        System.out.println("manual log DemoService add: " + points);
        return points;
    }
    @Override
    public int subtract(String userId, int points) {
        System.out.println("manual log DemoService subtract: " + points);
        return points;
    }
    @Override
    public int multiply(String userId, int points) {
        System.out.println("manual log DemoService multiply: " + points);
        return points;
    }
    @Override
    public int divide(String userId, int points) {
        System.out.println("manual log DemoService divide: " + points);
        return points;
    }
}
