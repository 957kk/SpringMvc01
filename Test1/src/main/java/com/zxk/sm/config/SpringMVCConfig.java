package com.zxk.sm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: SpringMvc01
 * @description: springMVC配置类
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-09-09 11:37
 **/
@Configuration
@ComponentScan(value = "com.zxk.sm", includeFilters =
@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
)
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    /**
     * 过滤静态资源
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }*/
}
