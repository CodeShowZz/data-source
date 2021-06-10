package com.dynamic.datasource.annotation;

import com.dynamic.datasource.constant.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author junlin_huang
 * @create 2021-06-10 5:42 PM
 **/

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {
    /**
     * 数据源名称
     */
    String value() default DataSourceConstants.DB_TEST;
}
