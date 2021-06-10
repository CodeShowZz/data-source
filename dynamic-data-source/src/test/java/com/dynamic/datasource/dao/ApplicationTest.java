package com.dynamic.datasource.dao;


import com.dynamic.datasource.Application;
import com.dynamic.datasource.constant.DataSourceConstants;
import com.dynamic.datasource.context.DynamicDataSourceContextHolder;
import com.dynamic.datasource.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author junlin_huang
 * @create 2021-06-09 11:40 PM
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void testDynamicDataSource() {
        Student student = studentDao.queryById(1);
        System.out.println(student);
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DB_LEARNING);
        System.out.println(userDao.selectById(1));
        DynamicDataSourceContextHolder.removeContextKey();
        DynamicDataSourceContextHolder.setContextKey(DataSourceConstants.DB_TEST);
        System.out.println(studentDao.queryById(1));
        DynamicDataSourceContextHolder.removeContextKey();
    }

    @Test
    public void testDynamicDataSourceUseAnnotation() {
        Student student = studentDao.queryById(1);
        System.out.println(student);
        System.out.println(userDao.selectById(1));
        System.out.println(studentDao.queryById(1));
    }
}