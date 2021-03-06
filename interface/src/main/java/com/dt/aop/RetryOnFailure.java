package com.dt.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/27
 * @Modified:
 * @Description:
 * @Date:
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface RetryOnFailure {
}
