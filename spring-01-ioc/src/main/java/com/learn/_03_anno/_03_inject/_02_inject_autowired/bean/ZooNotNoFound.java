package com.learn._03_anno._03_inject._02_inject_autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Autowired 注解的 required 属性控制自动注入的依赖是否必要，
 * 如果必要则依赖不存在时会报错提示。
 * 如果非必要则依赖不存在时不会报错提示。
 */
@Component
public class ZooNotNoFound {

    @Value("happyZooNotFound")
    private String name;

    @Autowired(required = false)
    private TmpDog tmpDog;

    @Override
    public String toString() {
        return "ZooNotNoFound{" +
                "name='" + name + '\'' +
                ", tmpDog=" + tmpDog +
                '}';
    }
}
