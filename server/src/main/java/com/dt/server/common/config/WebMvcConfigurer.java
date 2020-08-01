package com.dt.server.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: mingyang5
 * @Description:
 * @Date: 2020/3/23
 * @Modified:
 * @Description:
 * @Date:
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
