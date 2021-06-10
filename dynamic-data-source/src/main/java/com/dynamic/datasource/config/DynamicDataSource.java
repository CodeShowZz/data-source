package com.dynamic.datasource.config;

import com.dynamic.datasource.constant.DataSourceConstants;
import com.dynamic.datasource.context.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author junlin_huang
 * @create 2021-06-10 3:42 PM
 **/

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}