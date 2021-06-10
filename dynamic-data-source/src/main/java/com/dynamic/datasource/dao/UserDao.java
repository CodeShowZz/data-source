package com.dynamic.datasource.dao;

import com.dynamic.datasource.annotation.DS;
import com.dynamic.datasource.constant.DataSourceConstants;
import com.dynamic.datasource.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junlin_huang
 * @create 2021-06-10 5:34 PM
 **/

@Mapper
@DS(DataSourceConstants.DB_LEARNING)
public interface UserDao {

    User selectById(Integer id);

}