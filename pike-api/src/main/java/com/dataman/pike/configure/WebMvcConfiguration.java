package com.dataman.pike.configure;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
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
	
	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
	
	@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
        System.out.println("====================================");
        for (HttpMessageConverter<?> httpMessageConverter : converters) {
//        	if (httpMessageConverter instanceof StringHttpMessageConverter) {
//        		StringHttpMessageConverter tmp = (StringHttpMessageConverter) httpMessageConverter;
//				if(!tmp.getDefaultCharset().equals(Charset.forName("UTF-8"))){
//					tmp.setDefaultCharset(Charset.forName("UTF-8"));
//				}
//			}
			System.out.println(httpMessageConverter);
		}
        System.out.println("====================================");
    }
	
	
	

}
