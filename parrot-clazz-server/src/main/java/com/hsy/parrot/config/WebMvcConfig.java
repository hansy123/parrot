package com.hsy.parrot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ��SpringBoot2.0��Spring 5.0 WebMvcConfigurerAdapter�ѱ�������Ŀǰ�ҵ������������
 * 1 ֱ��ʵ��WebMvcConfigurer ���ٷ��Ƽ���
 * 2 ֱ�Ӽ̳�WebMvcConfigurationSupport
 * @ https://blog.csdn.net/lenkvin/article/details/79482205
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/client").setViewName("client");
        registry.addViewController("/index").setViewName("index");
    }
}
