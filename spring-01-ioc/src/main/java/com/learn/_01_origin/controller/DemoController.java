package com.learn._01_origin.controller;

import com.learn._01_origin.service.DemoService;
import com.learn._01_origin.service.impl.DemoServiceImplV1;
import com.learn._01_origin.service.impl.DemoServiceImplV2;
import com.learn._01_origin.service.impl.DemoServiceImplV3;
import com.learn._01_origin.service.impl.DemoServiceImplV4;
import org.junit.Test;

/**
 * 模拟 Controller 的业务逻辑：controller 通过 service 调用 dao 层获取数据库中数据。
 */
public class DemoController {

    // 使用第一种 V1 架构的 service 对象
    DemoService demoServiceV1 = new DemoServiceImplV1();
    DemoService demoServiceV2 = new DemoServiceImplV2();
    DemoService demoServiceV3 = new DemoServiceImplV3();
    DemoService demoServiceV4 = new DemoServiceImplV4();

    @Test
    public void getDemo() {
        System.out.println("V1 架构的结果：" + this.demoServiceV1.findAll().toString());
        System.out.println("V2 架构的结果：" + this.demoServiceV2.findAll().toString());
        System.out.println("V3 架构的结果：" + this.demoServiceV3.findAll().toString());
        System.out.println("V4 架构的结果：" + this.demoServiceV4.findAll().toString());
    }

}
