package com.learn._04_advanced._10_propertySource.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import java.util.Properties;

public class YmlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name,
                                                  EncodedResource resource) {
        // 1. 实例化 yaml 文件的解析组件
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean =
                new YamlPropertiesFactoryBean();

        // 2. 传入 resource 资源文件
        yamlPropertiesFactoryBean.setResources(resource.getResource());

        // 3. 解析组件直接解析获取 Properties 对象
        Properties yamlPropertiesFactoryProperties =
                yamlPropertiesFactoryBean.getObject();

        // 4. 如果 @PropertySource 注解的
        // name 属性没有指定资源文件的 name, 则使用资源文件名作为 name
        return new PropertiesPropertySource(
                name != null ? name : resource.getResource().getFilename(),
                yamlPropertiesFactoryProperties
        );
    }
}
