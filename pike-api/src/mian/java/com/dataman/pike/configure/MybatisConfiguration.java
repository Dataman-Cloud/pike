package com.dataman.pike.configure;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.miemiedev.mybatis.paginator.OffsetLimitInterceptor;

@Configuration
@MapperScan("com.dataman.pike.core.dao")
public class MybatisConfiguration {

//	@Bean
//    public PageHelper pageHelper() {
//        PageHelper pageHelper = new PageHelper();
//        Properties p = new Properties();
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
//        p.setProperty("reasonable", "true");
//        p.setProperty("dialect", "mysql");
//        pageHelper.setProperties(p);
//        return pageHelper;
//    }
	
	@Bean
	public Interceptor offsetLimitInterceptor(){
		OffsetLimitInterceptor interceptor = new OffsetLimitInterceptor();
		interceptor.setDialectClass("com.github.miemiedev.mybatis.paginator.dialect.MySQLDialect");
		return interceptor;
	}
}
