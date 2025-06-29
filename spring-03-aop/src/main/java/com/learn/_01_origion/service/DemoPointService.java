package com.learn._01_origion.service;

public interface DemoPointService {
    int add(String userId, int points);

    int subtract(String userId, int points);

    int multiply(String userId, int points);

    int divide(String userId, int points);
}
