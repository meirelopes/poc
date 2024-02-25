package com.meire.poc.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MdcInterceptor mdcInterceptor;


    public WebConfig(MdcInterceptor mdcInterceptor) {
        this.mdcInterceptor = mdcInterceptor;
    }


    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(mdcInterceptor).addPathPatterns("/usuarios");

        registry.addInterceptor(mdcInterceptor);
    }
}
