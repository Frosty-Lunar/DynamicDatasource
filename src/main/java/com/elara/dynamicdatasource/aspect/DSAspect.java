package com.elara.dynamicdatasource.aspect;

import com.elara.dynamicdatasource.aop.DS;
import com.elara.dynamicdatasource.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * DSAspect 是一个切面类，用于在方法调用前后切换数据源。
 * 它通过检查方法上的 @DS 注解来确定要使用的数据源，并在方法执行前后设置和移除数据源上下文。
 */
@Aspect
@Component
@Slf4j
public class DSAspect {

    /**
     * 定义一个切入点，匹配所有带有 @DS 注解的方法。
     */
    @Pointcut("@annotation(com.elara.dynamicdatasource.aop.DS)")
    public void dynamicDataSource() {
    }

    /**
     * 环绕通知，在匹配的方法执行前后切换数据源。
     *
     * @param point 连接点对象。
     * @return 方法执行结果。
     * @throws Throwable 如果方法执行过程中发生异常。
     */
    @Around("dynamicDataSource()")
    public Object datasourceAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DS ds = method.getAnnotation(DS.class);
        if (Objects.nonNull(ds)) {
            DataSourceContextHolder.setDatasource(ds.value());
        }
        try {
            return point.proceed();
        } finally {
            DataSourceContextHolder.removeDatasource();
        }
    }
}