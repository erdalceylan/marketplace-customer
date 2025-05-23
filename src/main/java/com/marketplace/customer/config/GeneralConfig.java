package com.marketplace.customer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GeneralConfig implements WebMvcConfigurer {


    private final HeaderInterceptor headerInterceptor;

    GeneralConfig(
            HeaderInterceptor headerInterceptor
    ){
        this.headerInterceptor = headerInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.headerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/dist/**", "/images/**", "/files/**", "/css/**", "/js/**", "/favicon.ico");

    }
}
