# Spring IOC 学习

## 项目目录结构

### 模拟 Spring 框架 IOC 容器的优势 
```
learn
├── _01_origin
│   ├── controller
│   │   └── DemoController.java
│   ├── dao
│   │   ├── DemoDao.java
│   │   └── impl
│   │       ├── DemoMySQLDaoImpl.java
│   │       └── DemoOracleDaoImpl.java
│   ├── factory
│   │   └── BeanFactory.java        # 静态工厂(分离实例化对象操作、反射创建对象、缓存已实例化对象)
│   └── service
│       ├── DemoService.java
│       └── impl
│           └── DemoServiceImpl.java
└── resources
    └── factory.properties          # 引入外部配置文件（文件保存类全限定名用于反射创建对象）
```

### IOC 容器开始（xml 文件配置）
```
learn
├── _02_xml
│   ├── _01_quickstart                     # Spring 框架 IOC 容器快速开始 
│   │  ├── GenericApplication.java         # 使用兼容容器类创建 IOC 容器
│   │  ├── QuickStartApplication.java.     # 使用配置文件容器类创建 IOC 容器
│   │  ├── dao
│   │  │   ├── JpaAccountDao.java
│   │  │   └── JpaItemDao.java
│   │  └── service
│   │      ├── PetStoreService.java
│   │      └── impl
│   │          └── PetStoreServiceImpl.java
└── resource
    ├── daos.xml
    └── services.xml
    
│   ├── _02_dependencyLookup              # Spring 框架 IOC 容器依赖查找（查找容器内的对象）
│   │   ├── DependencyLockupApplication.java  
│   │   ├── anno
│   │   │   └── Color.java                # 根据标记的注解查找依赖
│   │   └── bean
│   │       ├── Black.java
│   │       ├── Cat.java
│   │       ├── Dog.java
│   │       ├── Person.java
│   │       ├── Red.java
│   │       └── impl
│   │           ├── DemoDao.java           # 根据接口类型查找依赖
│   │           ├── DemoMySQLDaoImpl.java
│   │           ├── DemoOracleDaoImpl.java
│   │           ├── DemoPostgresDaoImpl.java
│   │           ├── InfoDao.java
│   │           └── InfoMySQLDaoImpl.java
└── resource
    └──dependencyLookup.xml

│   ├── _03_dependencyInject              # Spring 框架 IOC 容器依赖注入
│   │   ├── DependencyInjectApplication.java
│   │   └── bean
│   │       ├── Movie.java                # setter 依赖注入 & 构造器注入
│   │       ├── Director.java
│   │       ├── Complex.java              # 复杂类型依赖注入
│   │       └── Element.java
└── resource
    └──dependencyLookup.xml
```

### IOC 容器开始（注解配置）
```
learn
├── _03_anno
│   ├── _01_anno_bean                    # 基于配置类 + @Bean 注解创建 IOC 容器
│   │   ├── AnnoApplication.java         
│   │   ├── bean
│   │   │   ├── Item.java
│   │   │   └── Person.java
│   │   └── conf
│   │       └── BeanConfiguration.java   # @Configuration 配置 IOC 容器配置类 
│   ├── _02_component                           # 基于包扫描 + @Component 创建 IOC 容器
│   │   ├── BasePackagePathApplication.java     # 基于直接包路径扫描创建 IOC 容器
│   │   ├── ComponentScanApplication.java       # 基于配置类包扫描创建 IOC 容器
│   │   ├── bean
│   │   │   └── Info.java                       # @Component 注解创建实例
│   │   └── conf
│   │       └── ComponentScanConfiguration.java # IOC 容器配置类（@ComponentScan 指定包扫描 @Component 注解创建实例）
│   ├── _03_inject                                   
│   │   ├── _01_inject_value                       # @Value 注解依赖注入
│   │   │   ├── InjectComplexValueApplication.java # @Value 注解注入复杂类型依赖
│   │   │   ├── InjectValueApplication.java        # @Value 注解依入基本类型依赖
│   │   │   ├── bean
│   │   │   │   ├── Black.java
│   │   │   │   ├── Blue.java
│   │   │   │   ├── Green.java                     # @Value 注解 + SpEL 表达式注入
│   │   │   │   ├── Red.java                       # @Value + @PropertySource 从外部配置文件注入
│   │   │   │   └── White.java                     # @Value 注解 + SpEL 表达式注入
│   │   │   └── complexBean
│   │   │       ├── Complex.java
│   │   │       └── Element.java
│   │   ├── _02_inject_autowired                   # @Autowired 注解注入类类型依赖
│   │   │   ├── AutowiredApplication.java         
│   │   │   ├── AutowiredConfigurationApplication.java
│   │   │   ├── bean
│   │   │   │   ├── Dog.java
│   │   │   │   ├── TmpDog.java
│   │   │   │   ├── ZooBean.java
│   │   │   │   ├── ZooConstructor.java
│   │   │   │   ├── ZooField.java
│   │   │   │   ├── ZooNotNoFound.java
│   │   │   │   └── ZooSetter.java
│   │   │   └── conf
│   │   │       └── AutowiredBeanConfiguration.java
│   │   ├── _03_inject_autowired_unique           # @Autowired 注解注入同类型中的某一依赖 
│   │   │   ├── AutowiredComplexFieldApplication.java
│   │   │   ├── AutowiredUniqueApplication.java
│   │   │   ├── bean
│   │   │   │   ├── Cat.java
│   │   │   │   ├── Fish.java
│   │   │   │   ├── Sheep.java
│   │   │   │   ├── ZooByName.java              
│   │   │   │   ├── ZooPrimary.java               # @Primary 注解指定优先注入实例
│   │   │   │   └── ZooUnique.java                # @Qualifier 注解指定 name 注入
│   │   │   ├── complexBean
│   │   │   │   └── FishPond.java
│   │   │   └── conf
│   │   │       ├── ComplexFieldConfiguration.java
│   │   │       └── UniqueConfiguration.java
│   │   ├── _04_inject_resource                   # @Resource 注解注入类类型依赖
│   │   │   ├── ResourceInjectApplication.java
│   │   │   └── resourceBean
│   │   │       ├── Bird.java
│   │   │       └── Birdcage.java
│   │   └── _05_inject_aware                      # bean 创建后的容器回调注入特殊依赖
│   │       ├── AwareInjectApplication.java
│   │       └── bean
│   │           └── AwareTestBean.java
│   └── issue               # @Bean 和 @Value 注解执行顺序导致的依赖重复注入问题
│       ├── IssueApplication.java
│       ├── IssueConfiguration.java
│       ├── Person.java
│       └── YPerson.java
```

### IOC 容器进阶功能
```
learn
├── _04_advance
│   ├── _01_factoryBean                   # 使用 FactoryBean 创建 bean
│   │   ├── FactoryBeanApplication.java   # 实现 FactoryBean 接口利用工厂方法，创建初始化流程复杂的 bean
│   │   ├── bean
│   │   │   ├── Ball.java
│   │   │   ├── Car.java
│   │   │   ├── Child.java
│   │   │   ├── Toy.java
│   │   │   └── ToyFactoryBean.java
│   │   └── conf
│   │       └── FactoryBeanConfiguration.java
│   ├── _02_bean_scope                               # 单实例 bean 和原型 bean 的使用
│   │   ├── BeanScopeApplication.java               
│   │   ├── PrototypeBeanCreateTimeApplication.java  # 原型 bean 在 IOC 容器的创建时机
│   │   ├── bean
│   │   │   ├── Child.java
│   │   │   ├── ToyPrototype.java
│   │   │   └── ToySingleton.java
│   │   └── conf
│   │       └── BeanScopeConfiguration.java
│   ├── _03_bean_instantiate                   # IOC 容器配置使用实例工厂和静态工厂创建 bean
│   │   ├── BeanInstantiateApplication.java         
│   │   ├── bean
│   │   │   └── Car.java
│   │   └── factory
│   │       ├── CarInstanceFactory.java
│   │       └── CarStaticFactory.java
│   ├── _04_bean_lifecycle                           # 在 bean 生命周期的初始化和销毁阶段注册回调函数执行操作
│   │   ├── BeanInitDestroyApplication.java          # @Bean 注解配置回调方法
│   │   ├── ComponentInitDestroyApplication.java     # @Component 注解配置回调方法
│   │   ├── InterfaceInitDestroyApplication.java     # 实现接口配置回调方法
│   │   ├── MultipleInitDestroyApplication.java
│   │   ├── PrototypeBeanInitDestroyApplication.java # 原型 bean 在初始化和销毁阶段注册回调函数
│   │   ├── bean
│   │   │   ├── Cat.java
│   │   │   ├── Multiple.java
│   │   │   ├── Pen.java
│   │   │   ├── interfaceBean
│   │   │   │   └── pig.java
│   │   │   └── prototype
│   │   │       └── PrototypeBean.java
│   │   └── conf
│   │       ├── BeanInitDestroyConfiguration.java
│   │       ├── MultipleInitDestroyConfiguration.java
│   │       └── PrototypeBeanConfiguration.java
│   ├── _05_eventListener                           # Spring 框架的事件监听机制
│   │   ├── buildInEventLister                      # 监听 Spring 框架的内置事件 
│   │   │   ├── BuildInEventListenerApplication.java
│   │   │   └── listener                            # 定义内置事件监听器
│   │   │       ├── AnnoContextRefreshedEventListener.java
│   │   │       └── InterfaceContextRefreshedEventListener.java
│   │   └── customEventLister                       # 自定义事件和监听器
│   │       ├── CustomEventListenerApplication.java
│   │       ├── event                               # 自定义事件
│   │       │   └── RegisterSuccessEvent.java。     
│   │       ├── listener                            # 监听自定义事件的监听器
│   │       │   ├── EmailSenderListener.java。   
│   │       │   ├── MessageSenderListener.java    
│   │       │   └── SmsSenderListener.java
│   │       └── service                             # 事件发布器，向应用上下文广播事件
│   │           └── RegisterService.java
│   ├── _06_enableModule                       # Spring 的模块装配
│   │   ├── EnableTavernModuleApplication.java
│   │   ├── anno
│   │   │   └── EnableTavern.java              # 自定义 Enable 模块导入注解（使用 Import 注解导入模块组件）
│   │   ├── bean
│   │   │   ├── Bar.java
│   │   │   ├── Bartender.java
│   │   │   ├── Boss.java                      # Import 注解导入普通类 bean
│   │   │   └── Waiter.java
│   │   ├── conf
│   │   │   └── EnableTavernModuleConfig.java
│   │   └── module
│   │       ├── BartenderConfiguration.java    # Import 注解导入配置类中的 bean
│   │       ├── Registrar
│   │       │   └── WaiterRegistrar.java       # Import 注解导入 ImportBeanDefinitionRegistrar 注册的 BeanDefinition
│   │       └── selector                       # Import 注解导入 ImportSelector（配置类和普通类）
│   │           ├── BarConfiguration.java
│   │           └── BarImportSelector.java
│   ├── _07_profile                            # profile 注解基于环境配置决定是否注入 Bartender 实例
│   │   ├── DataSourceApplication.java         # 从外部配置文件中读取环境配置，决定使用生产/测试/开发的实例
│   │   ├── ProfileEnableTavernModuleApplication.java 
│   │   ├── anno
│   │   │   └── EnableTavern.java
│   │   ├── bean
│   │   │   ├── Bar.java
│   │   │   ├── Bartender.java
│   │   │   ├── Boss.java
│   │   │   └── Waiter.java
│   │   ├── conf
│   │   │   └── EnableTavernModuleConfig.java
│   │   ├── datasource
│   │   │   ├── DataSource.java                
│   │   │   └── DataSourceConfiguration.java
│   │   └── module
│   │       ├── BartenderConfiguration.java
│   │       ├── Registrar
│   │       │   └── WaiterRegistrar.java
│   │       └── selector
│   │           ├── BarConfiguration.java
│   │           └── BarImportSelector.java
│   ├── _08_conditional                       # Spring 的条件装配 
│   │   ├── basicUsage                        # @Conditional 注解的基础用法
│   │   │   ├── ConditionalEnableTavernModuleApplication.java
│   │   │   ├── anno
│   │   │   │   └── EnableTavern.java
│   │   │   ├── bean
│   │   │   │   ├── Bar.java
│   │   │   │   ├── Bartender.java
│   │   │   │   ├── Boss.java
│   │   │   │   └── Waiter.java
│   │   │   ├── condition
│   │   │   │   └── ExistBossCondition.java  # 定义条件注入的匹配条件（条件：容器中存在 Boss 类型的 bean 时注入）
│   │   │   ├── conf
│   │   │   │   └── ConditionalEnableTavernModuleConfig.java
│   │   │   └── module
│   │   │       ├── BartenderConfiguration.java
│   │   │       ├── Registrar
│   │   │       │   └── WaiterRegistrar.java
│   │   │       └── selector
│   │   │           ├── BarConfiguration.java # @Conditional 定义名为 BBbar 的 bean 当符合条件时才会被注入
│   │   │           └── BarImportSelector.java
│   │   └── customConditional               # 使用 @Conditional 注解定义通用的存在类才注入规则注解
│   │       ├── CustomConditionalEnableTavernModuleApplication.java
│   │       ├── anno
│   │       │   ├── ConditionalOnBean.java  # 自定义的存在类才注入注解
│   │       │   └── EnableTavern.java
│   │       ├── bean
│   │       │   ├── Bar.java
│   │       │   ├── Bartender.java
│   │       │   ├── Boss.java
│   │       │   └── Waiter.java
│   │       ├── condition
│   │       │   └── OnBeanCondition.java    # 定义条件注入的匹配条件，读取注解传参的存在类，如果类存在才导入
│   │       ├── conf
│   │       │   └── ConditionalEnableTavernModuleConfig.java
│   │       └── module
│   │           ├── BartenderConfiguration.java
│   │           ├── Registrar
│   │           │   └── WaiterRegistrar.java
│   │           └── selector
│   │               ├── BarConfiguration.java
│   │               └── BarImportSelector.java
│   ├── _09_advance_componentScan           # Spring 包扫描注解的进阶
│   │   ├── basePackageClassesComponentScan # 指定类的类型扫描，扫描指定类所在包及其子包的下的组件
│   │   │   ├── basePackageClassComponentScanApplication.java
│   │   │   ├── bean
│   │   │   │   ├── DemoDao.java
│   │   │   │   └── DemoService.java
│   │   │   ├── component
│   │   │   │   ├── DemoComponent.java
│   │   │   │   └── inner
│   │   │   │       └── InnerComponent.java
│   │   │   └── config
│   │   │       └── basePackageClassComponentScanConfig.java
│   │   └── filterComponentScan             # 按规则过滤的包扫描
│   │       ├── FilterComponentScanApplication.java
│   │       ├── animals
│   │       │   ├── Cat.java
│   │       │   ├── Dog.java
│   │       │   └── Pikachu.java
│   │       ├── anno
│   │       │   └── Animals.java            # 按注解过滤
│   │       ├── bean
│   │       │   ├── DemoDao.java            # 正则表达式过滤
│   │       │   └── DemoService.java
│   │       ├── color
│   │       │   ├── Color.java              # 按类型过滤
│   │       │   ├── Green.java
│   │       │   ├── Red.java
│   │       │   └── Yellow.java
│   │       ├── conf
│   │       │   └── FilterComponentScanConfig.java 
│   │       └── filter
│   │           └── GreenFilter.java        # 按编程式自定义过滤规则过滤
│   ├── _10_propertySource                  # @PropertySource 注解加载外部文件
│   │   ├── PropertySourceApplication.java
│   │   ├── bean
│   │   │   ├── JdbcProperties.java         # .properties 配置项实体类 + @Value 注入
│   │   │   └── JdbcYmlProperties.java      # .yml 配置项实体类 + @Value 注入
│   │   ├── config
│   │   │   ├── JdbcPropertiesConfiguration.java    # 读取 .properties 配置文件
│   │   │   └── JdbcYmlPropertiesConfiguration.java # 读取 .yml 配置文件
│   │   └── factory
│   │       └── YmlPropertySourceFactory.java       # yaml 配置文件解析策略类
│   ├── _11_BeanPostProcessor                       # Bean 后置处理器 BeanPostProcessor
│   │   ├── BeanPostProcessorApplication.java       # 在 Bean 初始化阶段前/后，拦截处理
│   │   ├── DestructionAwareBeanPostProcessorApplication.java   # 在 Bean 销毁前，拦截处理
│   │   ├── InstantiationAwareBeanPostProcessorApplication.java # 在 Bean 实例/注入前，拦截处理
│   │   ├── bean
│   │   │   ├── Ball.java
│   │   │   ├── Bird.java
│   │   │   └── Cat.java
│   │   ├── conf
│   │   │   ├── BeanPostProcessorConfig.java
│   │   │   ├── DestructionAwareBeanPostProcessorConfig.java
│   │   │   └── InstantiationAwareBeanPostProcessorConfig.java
│   │   └── processor
│   │       ├── AnimalBeanPostProcessor.java                   # 定义 bean 初始化阶段后置处理器
│   │       ├── AnimalDestructionAwareBeanPostProcessor.java   # 定义 bean 销毁阶段后置处理器
│   │       └── AnimalInstantiationAwareBeanPostProcessor.java # 定义 bean 实例化阶段后置处理器
```


