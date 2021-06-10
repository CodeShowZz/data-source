package com.dynamic.datasource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author junlin_huang
 * @create 2021-06-09 11:28 PM
 **/

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {

    private Integer id;

    private String name;

    private String roleId;
}