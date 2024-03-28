package com.learn.controller;

import com.learn.emtity.Department;
import com.learn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
  处理 Restful 架构请求的 Controller
  请求路径定义	普通接口请求路径	                    RESTful请求路径
  ------------------------------------------------------------------------
  根据id查部门	【GET】/department/findById?id=1	【GET】/department/1
  新增部门	    【POST】/department/save	        【POST】/department
  修改部门	    【POST】/department/update	        【PUT】/department/1
  删除部门	    【POST】/department/deleteById?id=1	【DELETE】/department/1

  重点: 使用 @PathVariable 注解解析 uri 中的变量
*/
@RestController
@RequestMapping("/rest-department")
public class RestfulDepartmentController {

    @Autowired
    DepartmentService departmentService;

    // GET rest-department/9
    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") String id) {
        // return departmentService.findById(id);
        System.out.println("restful get controller findById: id= " + id);
        return new Department("08", "RESTFUL-DEPT", "789323");
    }

    // POST rest-department/?name=jack&tel="9678"
    @PostMapping("/")
    public void save(Department department) {
        // departmentService.save(department);
        System.out.println("restful post controller save department: " + department);
    }

    // PUT rest-department/9?name=jack&tel="9678"
    // PUT rest-department/9/?name=jack&tel="9678"
    @PutMapping("/{id}")
    public void update(Department department, @PathVariable("id") String id) {
        // update ......
        System.out.println("restful put controller update department: " +
                           "id=" + id + " department=" + department);
    }

    // DELETE rest-department/9
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        // @PathVariable 注解如果不指定 value 值则默认使用方法形参名匹配占位符 {} 中的名字
        // 如 @PathVariable() String id 时 String id 匹配 {id}
        // departmentService.deleteById(id);
        System.out.println("restful delete controller delete department: id=" + id);
    }

    // GET rest-department/8/james/899323
    @GetMapping("/{id}/{name}/{tel}")
    public void multiPathVariable(@PathVariable("id") String id,
                                  @PathVariable("name") String name,
                                  @PathVariable("tel") String tel){
        System.out.println("restful get controller multiPathVariable:" +
                           " id=" + id + " name=" + name + " tel=" + tel );
    }
}
