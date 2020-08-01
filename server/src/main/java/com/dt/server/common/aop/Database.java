package com.dt.server.common.aop;

import java.lang.annotation.*;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/4
 * @Modified:
 * @Description:
 * @Date:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Database {
    String value() default "";
}
