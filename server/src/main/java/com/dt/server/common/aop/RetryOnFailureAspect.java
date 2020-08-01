package com.dt.server.common.aop;

import com.alibaba.fastjson.JSON;
import com.dt.server.common.config.MyPropsConfig;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/15
 * @Modified:
 * @Description:
 * @Date:
 */
@Aspect
@Component
@Slf4j
public class RetryOnFailureAspect {
    @Autowired
    MyPropsConfig config;

    @Pointcut("@annotation(RetryOnFailure)")
    public void retryOnOptFailure() {
        log.info("this is aop point");
    }

    /**
     * @Description:AOP增强实现
     * @param joinPoint
     * @return
     */
    @Around("retryOnOptFailure()")
    public Object doConcurrentOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        int retryTimes = config.getRetryTimes();
        Object[] args = joinPoint.getArgs();
        Exception throwable =null;
        for(int i=0;i<=retryTimes;i++) {
            try {
                return joinPoint.proceed();
            } catch (Exception ex) {
                log.error("[{}]执行失败,当前执行次数[{}],允许重试次数[{}],参数:[{}],失败原因:[{}]", method.getName(), i,
                        retryTimes, JSON.toJSONString(args),ex.getMessage());
                throwable=ex;
            }
        }
        throw throwable;
    }
}
