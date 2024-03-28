package com.learn._04_advanced._03_bean_instantiate.factory;


import com.learn._04_advanced._03_bean_instantiate.bean.Car;

/**
 * 创建 Car 类型 bean的实例工厂
 */
public class CarInstanceFactory {

    public Car getCar(){
        Car car = new Car();
        car.setName("car-instanceFactory");
        return car;
    }

}
