package com.learn.controller;

import com.learn.emtity.Department;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 支持以 Json 格式数据响应和请求的 Controller
 */
@Controller
// @RestController // 这个 Controller 中所有方法都是以 json 格式的数据返回的, 没有任何视图跳转。
@RequestMapping("/department")
public class JsonDepartmentController {

    /**
     * 将响应的 Department 对象转化为 json 格式数据返回
     */
    @GetMapping("/returnJson")
    @ResponseBody // 标记该方法以 json 的形式返回响应数据, 不做任何的视图解析
    public Department returnJson() {
        System.out.println("returnJson");
        return new Department("08", "RESTFUL-DEPT", "789323");
    }

    /**
     * 接受 json 格式请求数据，转化为 Department 对象处理
     */
    @PostMapping("saveJson") // 这个请求在 pages/dept/deptInfo.jsp 的 "保存JSON" 按钮中发起
    @ResponseBody
    public void saveJson(@RequestBody Department department){
        // @RequestBody 将请求体中请求的 json 数据转换为对象
        System.out.println("requestJson");
        System.out.println(department);

        // 如果点击 pages/dept/deptInfo.jsp 的 "保存JSON" 按钮没有反应,
        // 查看控制台发现请求 js/jquery.min.js 返回 404 找不到。
        // 这是因为 dispatchServlet 配置了拦截处理静态资源请求, 但是没有配置怎么解析这些静态资源
        // 所以不知道去哪里找这些静态资源报错 404

        // 解决方案: 在子容器的配置类 EnableWebConfiguration 中,
        // 重写 addResourceHandlers() 方法配置静态资源解析规则
    }

}
