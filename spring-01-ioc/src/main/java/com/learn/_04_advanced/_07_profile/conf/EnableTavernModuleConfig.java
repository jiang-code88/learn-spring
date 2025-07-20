package com.learn._04_advanced._07_profile.conf;

import com.learn._04_advanced._07_profile.module.anno.EnableTavern;
import org.springframework.context.annotation.Configuration;

@Configuration()
@EnableTavern // 开启装配酒馆模块的所有组件到应用（IOC容器）中
public class EnableTavernModuleConfig {
}
