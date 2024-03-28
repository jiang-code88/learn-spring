package com.learn._01_origin.controller;

import com.learn._01_origin.service.DemoService;
import com.learn._01_origin.service.impl.DemoServiceImpl;
import org.junit.Test;

/**
 * 模拟 Controller
 */
public class DemoController {

    DemoService demoService = new DemoServiceImpl();

    @Test
    public void getDemo() {
        System.out.println(this.demoService.findAll().toString());
    }

}
