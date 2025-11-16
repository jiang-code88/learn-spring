package com.learn._04_AOP_anno.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 接口实现的 service 类
 */
@Component
public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder() {
        System.out.println("OrderServiceImpl createOrder。。。");
    }

    @Override
    public void deleteOrderById(String id) {
        System.out.println("OrderServiceImpl deleteOrderById，id: " + id);
    }

    @Override
    public String getOrderById(String id) {
        System.out.println("OrderServiceImpl getOrderById，id: " + id);
        return id;
    }

    @Override
    public List<String> findAll() {
        System.out.println("OrderServiceImpl findAll。。。");
        return Arrays.asList("111", "222", "333");
    }
}

