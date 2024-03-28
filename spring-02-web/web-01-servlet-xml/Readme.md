Spring 整合 Web 开发(Tomcat 基于 web.xml 部署 web 应用)
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

导入 Servlet 的 API 接口依赖, 因为需要调用 Servlet 的 API 编写处理 http 请求的逻辑
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>

三、编写 IOC 容器配置文件 spring-web.xml
在 resource 目录下使用 spring-web.xml 文件配置 IOC 容器组件 bean。

四、编写 Tomcat 部署 web 应用的部署配置 web.xml
 1. 创建 webapp/WEB_INF/web.xml 文件, 配置 Listener 监听器根据 
    spring-web.xml 启动 IOC 容器。（webapp 目录与 java、resource 目录同级）
 2. 将容器放置到 application 应用全局作用域中。

五、编写 Servlet 映射处理请求（IOC 容器中取出 bean 使用）
 1. 继承 HttpServlet 编写 servlet
 2. 使用 @WebServlet(urlPatterns = "/user") 配置请求 url 映射
 3. 重写 doGet() 方法处理 "/user" 上的 get 请求
 4. 重写 init() 方法从 ServletContext 里面拿出 IOC 容器 WebApplicationContext，
    并从容器中取出 bean 保存使用。

六、编写 Servlet 映射处理请求（自动注入 IOC 容器中的 bean 使用）
重写 init() 方法使用 spring-web 提供的工具实现自动注入容器中的 bean
  SpringBeanAutowiringSupport
    .processInjectionBasedOnServletContext(this, servletContext);

附注：
idea 整合 Tomcat 运行 web 程序的步骤:
1. 导入 spring-web 依赖。
2. 导入 javax.servlet-api 依赖。
3. 创建项目, 创建 webapp 目录(与 java, resource 目录同级)。
4. 创建 webapp/WEB-INF 目录, 创建文件 web.xml。
5. 配置项目的打包方式为 war。
6. idea 在 Project Structure->Modules->web.xml 中配置 web.xml 的位置(先配置 WEB-INF 目录, 再配置 web.xml 文件)。
7. idea 在 Run/Debug Configuration 中配置一个 Tomcat 启动 (在 deployment 哪里的 Application Context 配置程序访问的 url 入口)。
8. 直接启动 Tomcat 程序即可。