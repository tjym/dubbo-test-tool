package com.dt.server;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/7/3
 * @Modified:
 * @Description:
 * @Date:
 */
@SpringBootApplication
@EnableSwagger2Doc
public class DubboTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboTestApplication.class, args);
    }
}
