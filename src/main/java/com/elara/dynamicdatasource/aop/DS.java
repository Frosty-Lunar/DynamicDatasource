package com.elara.dynamicdatasource.aop;

import java.lang.annotation.*;

/**
 * DS 是一个自定义注解，用于指定方法或类的数据源。
 * 它可以应用于方法和类型，允许在运行时根据注解值动态切换数据源。
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DS {
    /**
     * 该注解的值表示要使用的数据源名称。
     * 默认值为 "master"。
     *
     * @return 数据源名称。
     */
    String value() default "master";
}