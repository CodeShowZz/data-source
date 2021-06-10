package com.dynamic.datasource.aop;

import com.dynamic.datasource.annotation.DS;
import com.dynamic.datasource.context.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author junlin_huang
 * @create 2021-06-10 5:50 PM
 **/


@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.dynamic.datasource.annotation.DS)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        String dsKey = getDSAnnotation(joinPoint).value();
        DynamicDataSourceContextHolder.setContextKey(dsKey);
        try{
            return joinPoint.proceed();
        }finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }
    }

    /**
     * 根据类或方法获取数据源注解指定的值
     */
    private DS getDSAnnotation(ProceedingJoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        DS classAnnotation = targetClass.getAnnotation(DS.class);
        if (classAnnotation != null) {
            return classAnnotation;
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        return methodSignature.getMethod().getAnnotation(DS.class);
    }

}