package com.learn.controller;

import com.learn.emtity.Department;
import com.learn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
// @RequestMapping 标注在类上, 指定类中所有请求 URI 都以 /department 开头
// @RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    HttpServletRequest httpServletRequest;

    /********************** 服务测试程序 *************************/
    // 测试服务是否正常启动运行, 访问则直接跳转到 demo.jsp 页面
    @RequestMapping("/department/demo")
    public String demo() {
        return "demo";
    }

    /********************** 页面数据传递 *************************/
    // 需求: 加载所有部门的列表 GET /department/list
    // 基于 request 域的数据传递
    @RequestMapping("/department/list1")
    public String list1(HttpServletRequest request){
        request.setAttribute("deptList",
                departmentService.findDepartments(null));
        return "dept/deptList";
    }
    @RequestMapping("/department/list2")
    public String list2(){
        httpServletRequest.setAttribute("deptList",
                departmentService.findDepartments(null));
        return "dept/deptList";
    }

    // 基于 ModelAndView 的数据传递
    // 这种方式 ModelAndVies 既可以塞数据，也可以设置视图跳转和响应HTTP状态码
    @RequestMapping("/department/list3")
    public ModelAndView list3(ModelAndView modelAndView){
        // 使用 ModelAndView 封装数据和返回跳转的视图
        modelAndView.addObject("deptList",
                departmentService.findDepartments(null));
        modelAndView.setViewName("dept/deptList");
        return modelAndView;
    }
    @RequestMapping("/department/list4")
    public ModelAndView list4(){
        // 使用 ModelAndView 封装数据和返回跳转的视图
        ModelAndView mav = new ModelAndView();
        mav.addObject("deptList",
                departmentService.findDepartments(null));
        mav.setViewName("dept/deptList");
        return mav;
    }

    // 基于 ModelMap 或 Model 或 Map<String, Object> 的数据传递
    // 相当于简化了 ModeAndView, 数据单独塞 ModelMap/Model/Map, 视图返回字符串即可
    @RequestMapping("/department/list5")
    public String list5(ModelMap modelMap){
        modelMap.addAttribute("deptList",
                departmentService.findDepartments(null));
        return "dept/deptList";
    }
    @RequestMapping("/department/list6")
    public String list6(Map<String, Object> map){
        map.put("deptList",
                departmentService.findDepartments(null));
        return "dept/deptList";
    }
    @RequestMapping("/department/list7")
    public String list7(Model model){
        model.addAttribute("deptList",
                departmentService.findDepartments(null));
        return "dept/deptList";
    }


    /********************** 请求参数绑定 *************************/
    // 需求: 部门名称的模糊查询 GET /department/query?name=xxx
    // 基于 request 的请求参数收集
    @RequestMapping("/department/query1")
    public String query1(HttpServletRequest request){
        String name = request.getParameter("name");
        List<Department> deptList = departmentService.findDepartmentsByName(name);
        request.setAttribute("deptList", deptList);
        return "dept/deptList";
    }

    // 基于原生数据类型的参数收集
    @RequestMapping("/department/query2")
    public String query2(String name){ // 使用方法形参名匹配
        System.out.println("基于原生数据类型的参数收集");
        List<Department> deptList = departmentService.findDepartmentsByName(name);
        httpServletRequest.setAttribute("deptList", deptList);
        return "dept/deptList";
    }

    // 基于模型类的参数收集
    // 如果请求的参数名称，与模型类中成员变量一一对应，则可以直接使用模型类来接收
    @RequestMapping("/department/query3")
    public String query3(Department department){ // 使用模型类的成员变量名匹配
        System.out.println("基于模型类的参数收集");
        List<Department> deptList = departmentService.findDepartments(department);
        httpServletRequest.setAttribute("deptList", deptList);
        return "dept/deptList";
    }

    // 如果请求参数名和方法参数名不匹配时, 可以使用 @RequestParam 指定请求参数直接映射方法参数
    //  - required 为 true(默认) 表示该请求参数是必须出现的不存在则报错;
    //    false 表示该请求参数不是必须出现的，不存在将置为 null 不会报错
    //  - defaultValue 用于指定当请求参数不存在(不会报错不存在)或参数值为空字符时填充的默认值
    // 所以 required 和 defaultValue 不需要同时指定, 选其中一个使用就行。
    @RequestMapping("/department/query4")
    public String query4(HttpServletRequest request,
                         @RequestParam(value = "dept_name", required = false) String name){
        System.out.println("使用 @RequestParam 映射获取请求参数");
        List<Department> deptList = departmentService.findDepartmentsByName(name);
        request.setAttribute("deptList", deptList);
        return "dept/deptList";
    }


    /********************** 请求转发和重定向 *************************/
    // 需求: 删除部门 GET /department/delete?id=xxx
    // 删除部门后要执行请求转化或重定向的操作, 让页面刷新, 否则页面不会显示任何部门数据因为没有查询数据库
    // - 请求转发：forward:/department/list,
    //          等同于 request.getRequestDispatcher("/department/list").forward(request, response);
    // - 重定向：redirect:/department/list,
    //        等同于 response.sendRedirect("/department/list");
    @RequestMapping("/department/delete")
    public String delete(String id) {
        departmentService.deleteById(id);
        return "redirect:/department/list2"; // 重定向(URL会变化的跳转)
        // return "forward:/department/list2"; // 请求转发(URL不变化的跳转)
    }


    // 需求: 打开部门信息的修改 GET /department/edit?id=xxx
    @RequestMapping("/department/edit")
    public String edit(HttpServletRequest request, String id) {
        request.setAttribute("dept", departmentService.findById(id));
        return "dept/deptInfo"; // 跳转部门修改详情页面
    }

    /********************** Post 请求乱码 *************************/
    // 需求: 请求保存表单提交的部门信息修改 POST /department/save
    @RequestMapping("/department/save")
    public String save(Department department) {
        // 如果 Post 请求表单数据中包含中文, 默认会被 Tomcat 使用 "ISO-8859-1" 编码集解析, 然后乱码,
        // 需要增加配置一个 Filter 过滤器(指定使用 UTF-8 编码集解析), 避免乱码出现
        System.out.println("save department: " + department);
        return "redirect:/department/list2"; // 重定向到部门详情页面
    }

    /********************** HTTP 请求方法限定 *************************/
    // @RequestMapping 注解不指定请求方法限定时, 将接受所有 HTTP 方法的请求
    @RequestMapping(value = "/department/testMethod")
    public String testRequestMethod(){
        System.out.println("request All method");
        return this.list2();
    }

    // 只接受 GET 请求, 其他请求会返回报错 405 405 Method Not Allowed
    @RequestMapping(value = "/department/testGetMethod", method = RequestMethod.GET)
    // @GetMapping("/department/testGetMethod") // 上述的简便写法
    public String testGetMethod(){
        System.out.println("request get method");
        return this.list2();
    }

    // 只接受 POST 请求, 其他请求会返回报错 405 Method Not Allowed
    @RequestMapping(value = "/department/testPostMethod", method = RequestMethod.POST)
    // @PostMapping("/department/testPostMethod") // 上述的简便写法
    public String testPostMethod(){
        System.out.println("request post method");
        return this.list2();
    }

}
