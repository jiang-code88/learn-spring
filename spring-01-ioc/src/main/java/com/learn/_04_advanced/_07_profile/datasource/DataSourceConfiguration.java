package com.learn._04_advanced._07_profile.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

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
