package com.learn._04_AOP_anno.service;

import java.util.List;

public interface OrderService {

    void createOrder();

    void deleteOrderById(String id);

    String getOrderById(String id);

    List<String> findAll();
}
