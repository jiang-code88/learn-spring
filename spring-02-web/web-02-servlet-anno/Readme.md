Spring 整合 Web 开发(Tomcat 基于 Servlet 3.0 规范部署 web 应用)
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

三、无需配置 web.xml 在 web 容器启动时自动实现 IOC 容器的加载和创建
 1. 不需要创建和配置 webapp/WEB_INF/web.xml 文件, 
    而是继承  AbstractContextLoaderInitializer 实现 createRootApplicationContext() 方法。
 2. 实现方法中创建 IOC 容器，读取容器 xml 配置文件/读取配置类/包扫描创建 bean。
 3. 在启动 web 容器时将自动创建 IOC 容器并放置到 application 域（ServletContext）中供获取使用。