package com.learn._04_advanced._03_bean_instantiate.factory;


import com.learn._04_advanced._03_bean_instantiate.bean.Car;

/**
 * 创建 Car 类型 bean 的静态工厂
 */
public class CarStaticFactory {

    public static Car getCar(){
        Car car = new Car();
        car.setName("car-staticFactory");
        return car;
    }

}
