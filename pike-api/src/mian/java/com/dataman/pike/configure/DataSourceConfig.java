package com.dataman.pike.configure;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.dataman.pike.properties.DataSourceProperties;
import com.dataman.pike.properties.DruidProperties;

@Configuration
@EnableConfigurationProperties({ DataSourceProperties.class, DruidProperties.class })
public class DataSourceConfig {
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	@Autowired
	private DruidProperties druidProperties;
	
	
	@Bean  
    public DataSource dataSource() {  
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(dataSourceProperties.getUrl());  
        datasource.setDriverClassName(dataSourceProperties.getDriverClassName());  
        datasource.setUsername(dataSourceProperties.getUsername());  
        datasource.setPassword(dataSourceProperties.getPassword()); 
        datasource.setInitialSize(dataSourceProperties.getInitialSize());  
        datasource.setMinIdle(dataSourceProperties.getMinIdle());  
        datasource.setMaxWait(dataSourceProperties.getMaxWait());  
        datasource.setMaxActive(dataSourceProperties.getMaxActive());  
        datasource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());  
        try {  
            datasource.setFilters("stat,wall");  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return datasource;  
    } 
	
	
	/**
	 * druid 监控功能
	 * @return
	 */
	@Bean
	@ConditionalOnProperty(name = "druid.monitor.enabled", matchIfMissing = false)
	public ServletRegistrationBean druidStatView(){
		ServletRegistrationBean register = new ServletRegistrationBean();
		register.setName(druidProperties.getStatViewName());
		register.setServlet(new StatViewServlet());
		register.addUrlMappings(druidProperties.getUrlMappings());
		register.addInitParameter("loginUsername", druidProperties.getLoginUsername());
		register.addInitParameter("loginPassword", druidProperties.getLoginPassword());
		return register;
	}
	
	
}
