package com.learn._03_AOP_xml.service;

/**
 * 普通 service 类
 */
public class FinanceService {

    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }

    public double subtractMoney(double money){
        System.out.println("FinanceService 付钱 === " + money);
        throw new RuntimeException("abc");
        // return money;
    }

    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }
}

