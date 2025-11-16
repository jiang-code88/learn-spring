package com.learn._04_AOP_anno.service;

import com.learn._04_AOP_anno.anno.Log;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;
import sun.awt.AppContext;

/**
 * 普通 service 类
 */
@Component
public class FinanceService {
    public void addMoney(double money) {
        System.out.println("FinanceService addMoney === " + money);
    }

    @Log
    public double getMoneyById(String id) {
        System.out.println("FinanceService getMoneyById，id: " + id);
        return Math.random();
    }

    public double subtractMoneyThrowException(double money){
        System.out.println("FinanceService subtractMoney === " + money);
        throw new RuntimeException("FinanceService subtractMoney === " + money);
    }

    public void updateMoneyById(String id) {
        System.out.println("FinanceService updateMoneyById === " + id);

        // 代理对象调用自身方法，实际调用的是原始对象的方法，并不会调用到代理对象增强的方法。
        this.getMoneyById(id);

        // 获取当前类的代理对象，通过代理对象调用自身方法，调用的实际上时代理对象的方法，可以获得持续增强。
        FinanceService financeServiceProxy = (FinanceService) AopContext.currentProxy();
        financeServiceProxy.getMoneyById(id);
    }
}

