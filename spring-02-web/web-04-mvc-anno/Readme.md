整合 Spring-MVC 的 web 开发(基于 Servlet 3.0 的注解配置)
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
 1. 编写根容器的配置类 RootConfiguration
 2. 编写子容器的配置类 WebMvcConfiguration

四、配置 servlet 应用在 web 容器中的部署(替代 web.xml 的配置方式)
 1. SpringWebMvcInitializer 继承 AbstractAnnotationConfigDispatcherServletInitializer 实现方法
 2. 在 getRootConfigClasses() 方法的实现中返回根容器的配置类, 用于实例化根容器。
 3. 在 getServletConfigClasses() 方法的实现中返回子容器的配置类, 用于实例化子容器。
 4. 在 getServletMappings() 方法的实现中返回 DispatchServlet 的请求资源拦截。