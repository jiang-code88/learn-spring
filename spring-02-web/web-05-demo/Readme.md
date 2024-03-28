一、创建项目, 在 pom.xml 中设置项目打包方式为 war
   <packaging>war</packaging>

二、导入依赖
导入 Spring 的核心依赖 IOC 功能
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
</dependency>

导入 Spring 的 web 开发依赖
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
</dependency>

导入 Spring-MVC 依赖
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>${spring.framework.version}</version>
</dependency>

导入 Servlet 的 API 接口依赖
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>

导入 jsp 依赖
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>javax.servlet.jsp-api</artifactId>
    <version>2.3.3</version>
    <scope>provided</scope>
</dependency>

导入 jstl 依赖
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>

三、创建 IOC 容器的配置类
 1. 编写根容器配置类 RootConfiguration
    - 排除扫描创建 @Controller 的 bean 和 @Configuration 的 bean (防止把子容器配置类的 bean 放入根容器)
 2. 编写子容器配置类 WebMvcConfiguration
    1) 只扫描创建 @Controller 的 bean
    2) 配置创建视图解析器的 bean
    > 有两种实现方式: 方式一是 WebMvcConfiguration / 方式二是 EnableWebMvcConfiguration

四、配置 servlet 应用在 web 容器中的部署(替代 web.xml 的配置方式)
 1. WebMvcApplicationInitializer 继承 AbstractAnnotationConfigDispatcherServletInitializer 实现方法
 2. 在 getRootConfigClasses() 方法的实现中返回根容器的配置类。
 3. 在 getServletConfigClasses() 方法的实现中返回子容器的配置类。
 4. 在 getServletMappings() 方法的实现中返回 DispatchServlet 的请求资源拦截。

五、web 开发测试:
常规的 department 操作在 DepartmentController 中
 - 通过 src/main/webapp/WEB-INF/pages/dept/deptList.jsp 和 deptInfo.jsp 进行测试
 - POST 表单请求体信息中如果包含中文, 处理请求时会发现乱码。
   使用 FilterWebApplicationInitializer 中配置的过滤器, 指定 UTF-8 编码集解析防止乱码
restful 的 请求操作在 RestfulDepartmentController
  - 使用 postman 这种 url 请求发起工具测试

六、Spring-MVC 和 jackson 的整合实现接受 json 格式数据的请求和响应以 json 格式数据返回
1) # 导入 jackson 依赖
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-core</artifactId>
        <version>2.10.5</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.10.5</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-annotations</artifactId>
        <version>2.10.5</version>
    </dependency>
2) 配置 json 转换器
   注解搭建 spring-mvc 的 @EnableWebMvc 注解中已经自动配置了 json 转换器
3) 编写测试程序 JsonDepartmentController
   - 响应数据使用 Json 格式返回
   - 处理 Json 格式数据的请求
   > spring-mvc 拦截处理静态资源请求, 需要配置静态资源解析规则, 在子容器的配置类 EnableWebMvcConfiguration 中配置。

七、Spring-MVC 的 dispatcherServlet 自定义处理异常
   处理思路: 当触发了某个特定异常的时候，这个异常处理的过滤器会自动执行我们编写好的异常处理逻辑。
1) 使用 @ControllerAdvice 和 @ExceptionHandler 注解编写自定义异常处理类 CustomExceptionHandler
2) 使用 ExceptionController 来抛出异常测试。
3) CustomExceptionHandler 相当于每种异常定义一个 Controller, 抛出一种异常就触发执行一个映射方法处理

八、请求拦截器
1. Servlet、Filter、Listener 共同称为 Servlet 三大组件，它们都需要依赖 Servlet 的 API。
2. 拦截器是 SpringWebMvc 提出，它只是 SpringWebMvc 框架中的一个 API 设计罢了
    - 过滤器 Filter 是在 web.xml 或者借助 Servlet 3.0 规范来注册，任何来自于 Servlet 容器（Tomcat）的请求都会走这些过滤器
    - 拦截器既然是框架的概念，而 SpringWebMvc 的核心是一个 DispatcherServlet，
      所以拦截器实际上是在 DispatcherServlet 接收到请求后才有机会工作的，对于 DispatcherServlet 没有接收到的请求，拦截器只能干瞪眼。
    - 过滤器可以拦截几乎所有请求，而拦截器只能拦截到被 DispatcherServlet 接收处理的请求。
    - 过滤器的调用是一层一层的函数回调，而拦截器是 SpringWebMvc 在底层借助反射调用的

1) 自定义 Spring-MVC 拦截器
实现 HandlerInterceptor 接口的 preHandler() / postHandler() / afterCompletion() 方法
2) 配置拦截器
在 EnableWebMvcConfiguration 类中实现 addInterceptors() 用于注册自定义的拦截器
3) 配置多个拦截器时的执行顺序
- 增加定义一个 DemoExtraHandlerInterceptor() 拦截器
  具体在 EnableWebMvcConfiguration 类的 addInterceptors() 方法中有讲解