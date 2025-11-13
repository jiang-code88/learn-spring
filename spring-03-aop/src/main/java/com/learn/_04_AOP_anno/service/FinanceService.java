package com.learn._04_AOP_anno.service;

import com.learn._04_AOP_anno.aop.Log;
import org.springframework.stereotype.Component;

/**
 * 普通 service 类
 */
@Component
public class FinanceService {

    @Log
    public void addMoney(double money) {
        System.out.println("FinanceService addMoney === " + money);
    }

    public double subtractMoney(double money){
        System.out.println("FinanceService subtractMoney === " + money);
        throw new RuntimeException("FinanceService subtractMoney === " + money);
    }

    public double getMoneyById(String id) {
        System.out.println("FinanceService getMoneyById，id: " + id);
        return Math.random();
    }
}

