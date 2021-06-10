package com.dynamic.datasource.config;

import com.dynamic.datasource.constant.DataSourceConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author junlin_huang
 * @create 2021-06-10 3:35 PM
 **/

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = "com.dynamic.datasource.dao")
public class DynamicDataSourceConfig {

    @Bean(DataSourceConstants.DB_LEARNING)
    @ConfigurationProperties(prefix = "spring.datasource.learning")
    public DataSource learningDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(DataSourceConstants.DB_TEST)
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap(2);
        dataSourceMap.put(DataSourceConstants.DB_LEARNING, learningDataSource());
        dataSourceMap.put(DataSourceConstants.DB_TEST, testDataSource());
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(testDataSource());
        return dynamicDataSource;
    }
}