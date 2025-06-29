package com.learn._04_AOP_anno.service.impl;

import com.learn._04_AOP_anno.aop.Log;
import com.learn._04_AOP_anno.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 接口实现的 service 类
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Log
    @Override
    public void createOrder() {
        System.out.println("OrderServiceImpl 创建订单。。。");
    }

    @Override
    public void deleteOrderById(String id) {
        System.out.println("OrderServiceImpl 删除订单，id为" + id);
    }

    @Override
    public String getOrderById(String id) {
        System.out.println("OrderServiceImpl 查询订单，id为" + id);
        return id;
    }

    @Override
    public List<String> findAll() {
        System.out.println("OrderServiceImpl 查询所有订单。。。");
        return Arrays.asList("111", "222", "333");
    }
}

