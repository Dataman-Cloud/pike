package com.dataman.pike.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="druid")
public class DruidProperties {
	private String statViewName = "DruidStatView";
	private String urlMappings = "/druid/*";
	private String loginUsername = "admin";
	private String loginPassword = "admin";
	
	private boolean mergeSql = false;
	private long slowSqlMillis = 3000;
	private boolean logSlowSql = false;
	private boolean useGlobalDataSourceStat = false;
	public String getStatViewName() {
		return statViewName;
	}
	public void setStatViewName(String statViewName) {
		this.statViewName = statViewName;
	}
	public String getUrlMappings() {
		return urlMappings;
	}
	public void setUrlMappings(String urlMappings) {
		this.urlMappings = urlMappings;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public boolean isMergeSql() {
		return mergeSql;
	}
	public void setMergeSql(boolean mergeSql) {
		this.mergeSql = mergeSql;
	}
	public long getSlowSqlMillis() {
		return slowSqlMillis;
	}
	public void setSlowSqlMillis(long slowSqlMillis) {
		this.slowSqlMillis = slowSqlMillis;
	}
	public boolean isLogSlowSql() {
		return logSlowSql;
	}
	public void setLogSlowSql(boolean logSlowSql) {
		this.logSlowSql = logSlowSql;
	}
	public boolean isUseGlobalDataSourceStat() {
		return useGlobalDataSourceStat;
	}
	public void setUseGlobalDataSourceStat(boolean useGlobalDataSourceStat) {
		this.useGlobalDataSourceStat = useGlobalDataSourceStat;
	}
	
	
}

