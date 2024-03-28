# Spring MVC 学习

## 项目目录结构

```
├── web-01-servlet-xml    # Tomcat 容器（web.xml配置部署）+ IOC 容器（xml配置）+ 原生 Servlet 处理请求
│   ├── Readme.md
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── learn
│           │           ├── service
│           │           │   ├── DepartmentService.java
│           │           │   └── UserService.java
│           │           └── servlet
│           │               ├── DepartmentServlet.java   # Controller 方法
│           │               └── UserServlet.java
│           ├── resources
│           │   └── spring-web.xml    # 配置 IOC 容器 bean 创建
│           └── webapp
│               └── WEB-INF
│                   └── web.xml       # 配置 web 应用部署 Tomcat 配置(加载 IOC 容器)
├── web-02-servlet-anno   # Tomcat 容器（编程式配置部署）+ IOC 容器（配置类）+ 原生 Servlet 处理请求
│   ├── Readme.md
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── learn
│                       ├── DemoWebApplicationInitializer.java # 替代 web.xml 文件部署应用到 Tomcat
│                       ├── UserConfiguration.java             # IOC 容器配置类
│                       ├── UserService.java
│                       └── UserServlet.java                   # Controller 方法
│           
├── web-03-mvc-xml     # Tomcat 容器（web.xml配置部署）+ IOC 容器（xml配置）+ SpringMVC 处理请求
│   ├── Readme.md
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── learn
│           │           └── controller
│           │               └── DemoController.java
│           ├── resources
│           │   └── spring-mvc.xml  # 扫描 @Controller 注解标记 bean 到 IOC 容器中
│           └── webapp
│               └── WEB-INF
│                   ├── pages
│                   │   └── demo.jsp
│                   └── web.xml     # 配置 SpringMVC 的核心 DispatcherServlet
├── web-04-mvc-anno  # Tomcat 容器（编程式配置）+ IOC 容器（配置类）+ SpringMVC 处理请求
│   ├── Readme.md
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── learn
│           │           ├── SpringWebMvcInitializer.java  # 部署 web 应用的父子容器到 Tomcat
│           │           ├── config
│           │           │   ├── RootConfiguration.java    # 父容器配置（包含 Service、Dao 等通用 bean）
│           │           │   └── WebMvcConfiguration.java  # 子容器配置（只有 Controller bean）
│           │           └── controller
│           │               └── DemoController.java       
│           ├── resources
│           └── webapp
│               └── WEB-INF
│                   └── pages
│                       └── demo.jsp
└── web-05-demo    # SpringMVC 请求处理实践
    ├── Readme.md
    ├── pom.xml
    └── src
        └── main
            ├── java
            │   └── com
            │       └── learn
            │           ├── config
            │           │   ├── EnableWebMvcConfiguration.java       # 子容器配置（可以添加自定义请求拦截器一和二）
            │           │   ├── FilterWebApplicationInitializer.java 
            │           │   ├── RootConfiguration.java               # 父容器配置 
            │           │   └── WebMvcApplicationInitializer.java    # 配置 web 应用在 Tomcat 容器的部署配置
            │           ├── controller
            │           │   ├── DepartmentController.java        # 页面数据传递、请求参数绑定 @RequestParam、请求转发和重定向、请求方法限定
            │           │   ├── ExceptionController.java         # 触发抛出异常的请求处理，抛出的异常将由 CustomExceptionHandler 处理
            │           │   ├── JsonDepartmentController.java    # 接受和返回 JSON 格式数据的请求处理 @ResponseBody/@RestController/@RequestBody
            │           │   └── RestfulDepartmentController.java # Restful 请求处理（@PathVariable 解析 url 占位符参数、请求方法映射）
            │           ├── dao
            │           │   ├── DepartmentDao.java
            │           │   └── UserDao.java
            │           ├── emtity
            │           │   ├── Department.java
            │           │   └── User.java
            │           ├── exception
            │           │   └── CustomExceptionHandler.java      # @ControllerAdvice + @ExceptionHandler 增强 Controller 异常自定义处理逻辑
            │           ├── interceptor
            │           │   ├── DemoExtraHandlerInterceptor.java # 自定义请求拦截器一
            │           │   └── DemoHandlerInterceptor.java      # 自定义请求拦截器二
            │           └── service
            │               ├── DepartmentService.java
            │               └── UserService.java
            ├── resources
            └── webapp
                ├── WEB-INF
                │   └── pages
                │       ├── demo.jsp
                │       ├── dept
                │       │   ├── deptInfo.jsp
                │       │   └── deptList.jsp
                │       └── error.jsp
                └── js
                    └── jquery.min.js

61 directories, 53 files
```