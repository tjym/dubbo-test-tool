package com.dt.server.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/4/13
 * @Modified:
 * @Description:
 * @Date:
 */
@Data
@Configuration
public class MyPropsConfig {
    @Value("${dubbo.test.database:redis}")
    private String database;
    @Value("${dubbo.test.retry.times:2}")
    private int retryTimes;
    @Value("${dubbo.test.retry.timeout:6000}")
    private int timeout;
}
