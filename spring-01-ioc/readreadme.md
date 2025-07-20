# Spring IOC 学习
# TODO：
 - 不搞目录图谱，知识点列表图谱，知识点罗列「知识点描述（简短说明即可）」+ 补充实例代码具体在那个目录


# Spring 学习

## Spring IOC

### 模拟 Spring IOC 容器
代码目录：spring-01-ioc/src/main/java/com/learn/_01_origin

模拟 Controller-Service-Dao 的 MVC 框架，演示 Spring 框架的诞生演变之路：

- V1 架构：直接 new 实例化 Dao 层对象使用
- V2 架构：引入静态工厂集中实例化 Dao 层对象
- V3 架构：引入反射和外部配置文件控制 Dao 层实例对象实例化
- V4 架构：引入对象缓存实现对象复用（单例模式创建对象放入缓存）

### Spring IOC 容器 - XML 配置使用
#### 1. 快速开始
代码目录：spring-01-ioc/src/main/java/com/learn/_02_xml/_01_quickstart

Spring IOC 容器的快速使用示例，拥有 dao 层类、service 层类、然后使用 Application 类的 main 方法启动 IOC 容器，读取 daos.xml 和 services.xml 配置文件控制对象实例化放入容器。

- xml 配置的启动类 QuickStartApplication 需要使用 ClassPathXmlApplicationContext 类来启动容器。
- 使用 `<bean/>` 标签指定创建 bean 的 id 和全限定名。
- services.xml 中创建的 bean 使用 `<bean/>` 的子标签 `<property/>` 直接 dao 层成员变量名和注入的 bean 的 id。
- spring IOC 的依赖为：
    ```java
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.8.RELEASE</version>
    </dependency>
    ```

#### 2. IOC 容器依赖查找
代码目录：spring-01-ioc/src/main/java/com/learn/_02_xml/_02_dependencyLookup

IOC 容器中的 bean 查找方式
- 通过 bean name 获取
- 通过 bean 类型获取
- 通过 接口 类型获取（接口所有实现类的 bean）
- 获取被注解标记过的
- 获取容器中所有 bean 的 beanName （getBeanDefinitionNames）

> 如果用 `<bean/>` 定义 bean 没有使用 id 属性置顶 bean 的 beanName 那么 spring 会使用类的全限定名加数字作为 beanName，例如：
>
> com.learn._02_xml._02_dependencyLookup.bean.impl.DemoPostgresDaoImpl#0
> 
> com.learn._02_xml._02_dependencyLookup.bean.impl.DemoPostgresDaoImpl#1

#### 3. IOC 容器依赖注入
代码目录：spring-01-ioc/src/main/java/com/learn/_02_xml/_03_dependencyInject

xml 配置的 bean 依赖注入方式：
- setter 方法注入（`<bean/>` -> `<property>` -> name + value/ref）
- 构造器注入（`<bean/>` -> `<constructor-arg>` -> name + value/ref）
- 复杂依赖的注入，例如 数组、List、Set、Map、Properties 等类型依赖

### Spring IOC 容器 - 注解配置使用
#### 1. IOC 容器基本依赖查找和注入
代码目录：spring-01-ioc/src/main/java/com/learn/_03_anno/_01_BeanDependencyLookupAndInject

- @Configuration 注解标记的配置类代替 xml 配置文件。
- @Configuration 配置类中搭配 @Bean 注解实例化对象到容器中。
- 注解配置的 IOC 容器，启动类使用 AnnotationConfigApplicationContext 类，指定 @Configuration 注解标记的配置类来启动容器。

#### 2. @Component 模式注解 bean 导入容器
代码目录：spring-01-ioc/src/main/java/com/learn/_03_anno/_02_componentScan

- 配置 IOC 容器启动扫描标记 @Component 模式注解（@Controller 、@Service 、@Repository）的类，自动实例化对象注入容器
- Spring 注解配置启动类 AnnotationConfigApplicationContext 支持直接指定包路径（basePackage），扫描包以及子包的模式注解来实例 bean 创建容器；也支持指定配置类启动，但是配置类中需要使用 @ComponentScan 注解指定扫描包路径；

#### 3. 注解配置的 bean 依赖注入
代码目录：spring-01-ioc/src/main/java/com/learn/_03_anno/_03_componentDependencyInject

**@Value 注解注入**
1. 使用 @Value 注解注入「字符串表示的字面量」
2. 使用 @Value 注解 +「${}占位符」注入 properties 文件中指定的配置项值
3. 使用 @Value 注解 + SpEL表达式（#{}占位符）注入「字符串表示的字面量」、「容器中其他 bean 的成员变量值」、「方法调用返回值或类常量」、「数组、复杂类型 List、Set、Map、Properties成员变量的值」

**@AutoWired 注解注入**
1. @Autowired 注入 @Component 模版注解创建的 bean。
2. @Autowired 注入 @Configuration + @Bean 创建的 bean。
3. @Autowired 注入 多个 bean 到复杂类型的成员变量中，如 List 类型。

**@AutoWired 注解控制注入唯一（@Qualifier + @Primary）**
```
1.先拿属性对应的类型，去 IOC 容器中找 Bean，如果找到了一个，直接返回注入；
2.如果找到多个类型一样的 bean，根据 @Qualifier 指定的 beanName 去找，找到直接返回注入；
3.找不到则找标记了 @Primary 注解的 bean，如果只找到一个，直接返回注入；
4.否则把属性名拿过来，跟这些 bean 的 id 逐个对比，如果有一个相同的，直接返回；
5.如果没有任何相同的 id 与要注入的属性名相同，则会抛出 NoUniqueBeanDefinitionException 异常。
```

**@Resource 注解注入**

属于 JSR250 规范（Java Specification Requests）定义了很多 Java 语言开发的规范。

```
@Resource 也是用来属性注入的注解，它与 @Autowired 的不同之处在于：
    - @Autowired 是首先按照类型注入，然后经过 @Qualifier、@Primary，
       最后拿成员变量名和 bean 名称匹配注入。
    - 而 @Resource 是首先按照成员变量名匹配 Bean 名称注入，
       找不到再用类型匹配注入（相同类型的多个 bean 也会报错）
```

**aware 接口回调注入**

在一个使用 @Component 注解标记的 bean 被容器创建好后，可以通过实现 Aware 系列的回调接口，将一些特定的信息注入到 bean 中。

常用的注入接口：
```
BeanFactoryAware	            回调注入 BeanFactory
ApplicationContextAware	        回调注入 ApplicationContext
EnvironmentAware	            回调注入 Environment
ApplicationEventPublisherAware	回调注入事件发布器
ResourceLoaderAware	            回调注入资源加载器
BeanClassLoaderAware	        回调注入加载当前 Bean 的 ClassLoader
BeanNameAware	                回调注入当前 Bean 的名称
```
在 Spring5 中其中大部分都可以通过 @AutoWired 实现注入了，不再需要实现接口注入。

### Spring IOC 容器 - Bean 作用域（单实例和原型）
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_02_bean_scope

- 单实例 bean：从一个 IOC 容器中只能获取到同一个 bean（Spring默认行为）

- 原型 bean：每次获取都是重新创建的 bean
    ```java
    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 设置作用域为原型
    public class ToyPrototype { ... }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean(){ ... }
    ```
    使用 @Scope 注解设置在 @Bean 或 @Component 注解上并定义属性值。

### Spring IOC 容器 - Bean 生命周期（初始化和销毁回调方法）
##### 1. @Bean + initMethod / destroyMethod 属性
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_04_bean_lifecycle/BeanInitDestroyApplication.java

初始化回调函数：在 bean 被实例化再执行 setter 方法注入属性后才回调执行。
销毁回调函数：在 bean 被销毁回收前调用。

```java
// 使用 @Bean 注解的 initMethod 和 destroyMethod 属性配置
@Bean(initMethod = "init", destroyMethod = "destroy")
public Cat cat(){
    Cat cat = new Cat();
    cat.setName("cat");
    return cat;
}
```
回调函数必备特征：
- 方法访问权限无限制要求（public 还是 private 并不影响）
- 方法无参数
- 方法无返回值
- 可以抛出异常（异常不由自己处理，交予 SpringFramework 可以打断 Bean 的初始化 / 销毁步骤）

##### 2. @Component + @PostConstruct / @PreDestroy
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_04_bean_lifecycle/ComponentInitDestroyApplication.java

属于 JSR250规范定义的注解。

```java
@Component
public class Pen {
    @PostConstruct
    public void addInk(){
        System.out.println("钢笔中已加满墨水...");
    }
    @PreDestroy
    public void outwellInk(){
        System.out.println("钢笔中的墨水都放干净了...");
    }
}
```
其实去掉 @Component 注解改为使用 @Bean 创建实例对象也可以用到 @PostConstruct / @PreDestroy 注解的方法。

@Bean 和 @Component 共存时，@Component 的初始和销毁方法，执行优先级高于 @Bean。
```
>>>> 准备初始化 IOC 容器
@Component + @PostConstruct + @PreDestroy : pen1 钢笔中已加满墨水...
@Bean + @PostConstruct + @PreDestroy : pen2 钢笔中已加满墨水...
<<<< 初始化 IOC 容器完成

>>>> 准备销毁 IOC 容器
@Bean + @PostConstruct + @PreDestroy : pen2 钢笔中的墨水都放干净了...
@Component + @PostConstruct + @PreDestroy : pen1 钢笔中的墨水都放干净了...
<<<< 销毁 IOC 容器完成
```

##### 2. @Component + 实现 InitializingBean / DisposableBean 接口
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_04_bean_lifecycle/InterfaceInitDestroyApplication.java

Spring 框架内部预先定义好的关于生命周期的接口。

```java
@Component
public class Pig implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name + " 被初始化了...");

    }
    @Override
    public void destroy() throws Exception {
        System.out.println(name + " 被销毁了...");
    }
}
```

其实去掉 @Component 注解改为使用 @Bean 创建实例对象也可以用到实现 InitializingBean 和 DisposableBean 接口的初始化销毁方法。

@Bean 和 @Component 共存时，@Component 的初始和销毁方法，执行优先级高于 @Bean。
```
>>>> 准备初始化 IOC 容器
@Component + InitializingBean 接口 + DisposableBean 接口 : pig1 被初始化了...
@Bean + InitializingBean 接口 + DisposableBean 接口 : pig2 被初始化了...
<<<< 初始化 IOC 容器完成

>>>> 准备销毁 IOC 容器
@Bean + InitializingBean 接口 + DisposableBean 接口 : pig2 被销毁了...
@Component + InitializingBean 接口 + DisposableBean 接口 : pig1 被销毁了...
<<<< 销毁 IOC 容器完成
```

##### 3. 三种方式并存
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_04_bean_lifecycle/MultipleInitDestroyApplication.java

三种方式并存时的执行顺序：
```
@PostConstruct+@PreDestroy 注解
    -> InitializingBean+DisposableBean接口
        ->@Bean(initMethod+destroyMethod) 属性
```
执行效果：
```
>>>> 准备初始化 IOC 容器
Multiple: 构造器被调用...
multiple1 @PostConstruct 注解 - 初始化
multiple1 InitializingBean 接口 - 初始化...
Multiple: 构造器被调用...
multiple2 : setter 方法被调用...
multiple2 @PostConstruct 注解 - 初始化
multiple2 InitializingBean 接口 - 初始化...
multiple2 initMethod 属性 - 初始化...
<<<< 初始化 IOC 容器完成

>>>> 准备销毁 IOC 容器
multiple2 @PreDestroy 注解 - 销毁...
multiple2 DisposableBean 接口 - 销毁...
multiple2 destroyMethod 属性 - 销毁...
multiple1 @PreDestroy 注解 - 销毁...
multiple1 DisposableBean 接口 - 销毁...
<<<< 销毁 IOC 容器完成
```

##### 4. 原型 Bean 的初始化和销毁方法
原型 bean 每次获取 bean 时都会进行实例化对象，都会调用一次三种初始化方法，这一点和单实例 bean 是完全一致的。

原型 bean 在 IOC 容器被销毁时，也会执行销毁方法。但是和单实例 bean 不同的是，原型 bean 不会调用 @Bean 注解的 destroyMethod 属性定义的销毁方法，除此之外的销毁方法调用都是完全一致的。

### Spring IOC 容器 - 事件机制
事件发布器 -> 事件 -> 事件监听器
- 不同的时机触发事件发布器发布事件
#### Spring 配置绑定事件监听
使用「注解绑定的监听器」比「实现接口绑定的监听器」先触发执行
**实现接口绑定的监听器**
```java
@Component
public class InterfaceContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    // 监听 Spring 框架内置 ContextRefreshedEvent 事件，表示 "容器刷新完毕（所有单实例 Bean 刚创建完成）" 事件, 触发于 "IOC 容器刷新完毕但尚未启动时"
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ContextRefreshApplicationListener 监听器(实现接口绑定的监听器), " +
                        "监听到 ContextRefreshedEvent 事件的发生");
    }
}
```
- 实现 ApplicationListener<ContextRefreshedEvent> 接口的 onApplicationEvent 方法，监听 ContextRefreshedEvent 事件，当该事件发生时会调用 onApplicationEvent 方法的实现逻辑。
- 监听类必须标记 @Component 注解，放入 IOC 容器才生效。

**注解绑定的监听器**
```java
@Component
public class AnnoContextRefreshedEventListener {
    // 监听 Spring 框架内置 ContextRefreshedEvent 事件，表示 "容器刷新完毕（所有单实例 Bean 刚创建完成）" 事件, 触发于 "IOC 容器刷新完毕但尚未启动时"
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ContextRefreshApplicationListener 监听器(注解标记绑定的监听器), " +
                        "监听到 ContextRefreshedEvent 事件的发生");
    }
}
```
- 在监听事件并触发执行的方法上加上 @EventListener 注解，不同的方法参数定义监听的不同的事件，这里监听的是 ContextRefreshedEvent 事件。

#### Spring 框架内置可监听事件
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_05_eventListener/buildInEventLister/BuildInEventListenerApplication.java

Spring 默认内置事件（可以使用监听器默认监听 IOC 容器的以下事件）:
- ContextRefreshedEvent 事件, 表示 "容器刷新完毕（所有单实例 Bean 刚创建完成）" 事件, 触发于 "IOC 容器刷新完毕但尚未启动时"
- ContextClosedEvent 事件, 表示 "容器即将关闭" 事件, 触发于 "IOC 容器已经关闭但尚未销毁所有 Bean 时"
- ContextStartedEvent 事件, 表示 "容器启动完毕" 事件, 触发于 "ContextRefreshedEvent 触发后 + 所有实现了 Lifecycle 接口的 Bean 执行回调 start 方法后"
- ContextStoppedEvent 事件, 表示 "容器关闭完毕" 事件, 触发于 "ContextClosedEvent 触发之后"

#### Spring 自定义事件发布和监听
代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_05_eventListener/customEventLister/CustomEventListenerApplication.java

**事件**
```java
public class RegisterSuccessEvent extends ApplicationEvent {
    private String username;
}
```
- 继承 ApplicationEvent 类，表示为一个事件类，每次事件发布时是传递一个事件类的实例对象。

**事件发布器**
```java
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username){
        System.out.println(username + " 注册成功...");
        // 创建一个注册成功事件
        RegisterSuccessEvent event = new RegisterSuccessEvent(this);
        event.setUsername(username);
        // 发布注册成功事件
        applicationEventPublisher.publishEvent(event);
    }
}
```
- 事件发布器使用 Spring IOC 容器提供的 ApplicationEventPublisher 实例对象发布事件给监听器。
  这个 ApplicationEventPublisher 实例对象，通过实现 ApplicationEventPublisherAware 回调接口回调注入。
- 到达事件触发的时机时，调用 register 方法，发布一个事件实例对象。

**事件监听器**
```java
// 实现接口绑定的监听器
@Component
@Order(-1) // 最先发送短信通知
public class SmsSenderListener implements ApplicationListener<RegisterSuccessEvent> {
    @Override
    public void onApplicationEvent(RegisterSuccessEvent event) {
        System.out.println("监听到 \""+ event.getUsername() +"\" 用户注册成功，" +
                "发送短信(实现接口绑定)...");
    }
}

// 注解绑定的监听器
@Component
public class EmailSenderListener {
    @EventListener
    @Order // 最后发送邮件通知
    public void onRegisterSuccess(RegisterSuccessEvent event) {
        System.out.println("监听到 \"" + event.getUsername() + "\" 用户注册成功，" +
                "发送邮件(注解绑定)...");
    }
}
```
- @order 注解定义监听器执行顺序。默认「注解绑定的监听器」比「实现接口绑定的监听器」先执行，@order 可以直接打破，重新定义顺序。
- @order 的顺序值值越小，执行顺序最先，不标记 @Order 时方法的顺序值为 0，标记 @Order 不指定顺序值时最大值（Integer.MAX_VALUE）表示最后执行。
- @order 可以填负数（例如 -1），表示最先执行。

### Spring IOC 容器 - 模块装配（@Enablexxx）
SpringBoot 自动装配功能的实现基础

代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_06_enableModule/EnableTavernModuleApplication.java

不使用 @Bean 或者 @Component 逐个标记类的方式，实现批量指定类创建实例化对象放入容器，使用的核心是「自定义注解（Enablexxx注解）」+「Import 注解」导入一整个模块的组件。最终你会发现那个多类被创建实例放入容器，但一个 @Component 注解都不需要用到。 

**自定义注解（Enablexxx注解）**

```java
@Documented
@Retention(RetentionPolicy.RUNTIME) // 表示在运行时生效
@Target(ElementType.TYPE)           // 表示只能标记在类上
@Import() // 配置自动装配该模块时所需要导入的 bean
public @interface EnableTavern {}
```
这个注解只需要标记在你需要导入该模块组件的项目的配置类上即可完成模块的导入。

**Import 注解**

这个注解支持四种 bean 的导入方式：
- 导入普通类为实例化 bean
- 导入配置类中定义要实例化的 bean
- 导入 ImportSelector 接口实现类中定义要实例化的 bean
- 导入 ImportBeanDefinitionRegistrar 接口实现类中定义要实例化的 bean
```java
@Import({Boss.class,                  // 导入普通类 bean
        BartenderConfiguration.class, // 导入配置类中的 bean
        BarImportSelector.class,      // 使用 ImportSelector 实现类导入（ImportSelector 支持导入普通类和配置类）
        WaiterRegistrar.class})       // 使用 ImportBeanDefinitionRegistrar 实现类导入
```

### Spring IOC 容器 - 条件装配
#### 环境配置条件装配（@Profile）
模块装配的一个缺点是默认会装配整个模块中所有的组件，无法实现根据不同的配置，调整装配模块中的那些组件，也就是无法动态的装配模块中匹配当前配置的组件。@Profile 条件装配就是用来实现这个需求的，提供根据当前项目的运行时环境不同，动态的注册当前运行环境匹配的组件。

代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_07_profile/ProfileEnableTavernModuleApplication.java

使用 @Profile 注解标记在 @Bean 注解的方法或 @Configuration 注解标记的配置类中，配置这些 bean 要匹配哪些环境配置值时才注入容器中。
```java
@Configuration()
@Profile("city") // 配置类中 Bartender 的实例将按条件注入，条件为 "city"
public class BartenderConfiguration {
    @Bean
    public Bartender bartenderJohn(){ ... }

    @Bean
    public Bartender bartenderPaul(){ ... }
}

@Configuration
public class DataSourceConfiguration {
    @Bean
    @Profile("default")
    public DataSource prodDataSource(){ ... }

    @Bean
    @Profile("dev")
    public DataSource devDataSource(){ ... }

    @Bean
    @Profile("test")
    public DataSource testDataSource(){ ... }
}
```
- 默认情况下，ApplicationContext 中的 profile 为 "default"

具体使用场景举例：

代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_07_profile/DataSourceApplication.java

根据开发环境/测试环境/生产环境, 不同环境切换使用不同的具体数据源注入容器中使用。
具体通过外部配置文件 datasource.properties 中，配置项 spring.profiles.active 的值不同来切换。
```java
@Configuration
@PropertySource("classpath:_04_advance/_07_profile/datasource.properties")
public class DataSourceConfiguration {
    // 生产（production）环境导入该 bean（默认导入该 bean）
    @Bean
    @Profile("default")
    public DataSource prodDataSource(){
        return new DataSource("prod-datasource");
    }

    // 开发环境激活时导入该 bean
    @Bean
    @Profile("dev")
    public DataSource devDataSource(){
        return new DataSource("dev-datasource");
    }

    // 测试环境激活时导入该 bean
    @Bean
    @Profile("test")
    public DataSource testDataSource(){
        return new DataSource("test-datasource");
    }
}
```
datasource.properties  配置文件内容
```java
# Activate the development environment
#spring.profiles.active=dev

# Activating the test environment
spring.profiles.active=test
```
- 外部配置文件通过 @PropertySource 注解实现读取，这个注解使用在配置类上，需要指定配置文件路径。

#### Bean 关系条件装配（@Conditional）
@Profile 的条件装配是基于环境配置不同而动态决定是否注册 bean 到容器中的，环境配置是整个项目的运行环境，这个控制范围太广，无法需要根据单个 bean 的因素来控制其他 bean 是否装配。@Conditional 条件装配就可以实现这个需求。

代码目录：spring-01-ioc/src/main/java/com/learn/_04_advanced/_08_conditional/basicUsage/ConditionalEnableTavernModuleApplication.java

在 @Bean 注解标记的 bean 创建方法上，添加 @Conditional 注解，在注解中指定 Condition 接口的实现类（条件匹配规则类），这个实现类中实现 matches 方法定义 bean 是否要被注入的判断逻辑。

```java
@Configuration
public class BarConfiguration {
    @Bean
    // 注入该 bean 前会先判断是否符合 ExistBossCondition.class 中定义的条件，符合才注入否则不注入。
    @Conditional(ExistBossCondition.class)
    public Bar barConfigurationSelector(){
        return new Bar();
    }
}

public class ExistBossCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        // 匹配规则：存在 beanName 为 com.learn._04_advanced._08_conditional.basicUsage.module.bean.Boss 的 BeanDefinition 存在则为匹配规则导入，不存在则为不匹配规则不导入。
        return context.getBeanFactory().containsBeanDefinition(Boss.class.getName());
    }
}
```

@Conditional 注解支持派生外更加通用的自定义条件装配注解，如上述的例子可以抽象为 @ConditionalOnBean 注解，通过参数指定 Bean 的类型，自动判断指定的 Bean 类型存在与否然后决定是否注入注解标记的 bean，不再局限于只能判断 Boss 类型 bean 是否存在，代码复用性太差。

```java
@Configuration
public class BarConfiguration {
    @Bean
    @ConditionalOnBean(Boss.class)
    public Bar barConfigurationSelector(){
        return new Bar();
    }
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {
    Class<?>[] value() default {};
}

public class OnBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1 获取目标自定义注解 ConditionalOnBean 上的 beanNames 属性
        Class<?>[] beans = (Class<?>[]) metadata
                .getAnnotationAttributes(ConditionalOnBean.class.getName())
                .get("value");

        // 2 逐个校验 IOC 容器中是否包含传入的 beanName
        for(Class<?> bean : beans){
            if(context.getBeanFactory().containsBeanDefinition(bean.getName())){
                return true;
            }
        }
        return false;
    }
}
```
- 之前的关系条件匹配要指定 @Conditional 注解和条件匹配规则类（matches 方法定义判断逻辑），派生的 @ConditionalOnBean 注解只需要指定条件匹配规则类需要的某个参数，然后就可以自动的去调 @Conditional 注解然后把参数传递到条件匹配规则类的判断逻辑中进行判断。

