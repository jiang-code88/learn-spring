SpringWebMvc 是基于 Servlet 规范之上实现的,所以要运行基于 SpringWebMvc 的项目，
需要 Servlet 容器服务器支撑(Tomcat、Jetty 等)
Spring-MVC 的核心控制器是一个 Servlet, 叫做 DispatchServlet

整合 Spring-MVC 的 web 开发(基于 web.xml 配置)
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

三、配置 IOC 容器的
 1. 创建文件 spring-mvc.xml
 2. 在文件中配置包扫描, 创建标记 @Controller 注解类的 bean
 3. 配置创建视图解析器的 bean

四、配置 web.xml 文件(配置 servlet 应用在 web 容器中的部署)
 1. 配置一个 Spring-MVC 的核心 DispatchServlet
 2. 配置 IOC 容器 xml 配置文件的路径用于加载容器。
 3. 配置该 servlet 的请求资源拦截

