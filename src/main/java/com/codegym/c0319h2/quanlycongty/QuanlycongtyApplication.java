package com.codegym.c0319h2.quanlycongty;

import com.codegym.c0319h2.quanlycongty.converter.StringToLocalDateConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class QuanlycongtyApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(QuanlycongtyApplication.class, args);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        StringToLocalDateConverter stringToLocalDateConverter = new
                StringToLocalDateConverter("yyyy-MM-dd");
        registry.addConverter(stringToLocalDateConverter);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for images
//        registry.addResourceHandler("/images/**").addResourceLocations("/imageUser/images/")
//                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

        registry.addResourceHandler("/arrImg/**").addResourceLocations("/images/arrImg/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
        registry.addResourceHandler("/user/**").addResourceLocations("/images/user/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
        registry.addResourceHandler("/logo/**").addResourceLocations("/images/logo/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

}
