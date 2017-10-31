package com.dataman.pike.configure;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/").setViewName("redirect:/static/"); // 添加首页
		// registry.addViewController("/manager").setViewName("redirect:/static/account.html"); // 添加管理页面
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/swagger/");
	}
	
	@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //converters.add(mappingJackson2HttpMessageConverter());
        System.out.println("====================================");
        for (HttpMessageConverter<?> httpMessageConverter : converters) {
			System.out.println(httpMessageConverter);
		}
        System.out.println("====================================");
    }
	
}
