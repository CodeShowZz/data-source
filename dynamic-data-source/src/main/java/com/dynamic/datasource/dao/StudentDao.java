package com.dynamic.datasource.dao;

import com.dynamic.datasource.annotation.DS;
import com.dynamic.datasource.constant.DataSourceConstants;
import com.dynamic.datasource.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author junlin_huang
 * @create 2021-06-09 11:30 PM
 **/

@Mapper
public interface StudentDao {

    @DS(DataSourceConstants.DB_TEST)
    Student queryById(Integer id);
}