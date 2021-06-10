package com.dynamic.datasource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author junlin_huang
 * @create 2021-06-10 5:35 PM
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    private Integer id;

    private String name;
}