package com.dynamic.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author junlin_huang
 * @create 2021-06-09 11:40 PM
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.dynamic.datasource.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}