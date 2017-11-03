package com.dataman.pike.configure;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dataman.pike.properties.JenkinsProperties;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.helper.JenkinsVersion;

@Configuration
@EnableConfigurationProperties(JenkinsProperties.class)
public class JenkinsConfiguration {
	@Autowired
	JenkinsProperties properties;
	
	@Bean
	public JenkinsServer jenkinsServer() throws URISyntaxException{
		JenkinsServer jenkinsServer= new JenkinsServer(new URI(properties.getUrl()), 
				properties.getUser(), properties.getPassword());
		System.out.println("jenkins is Running :" +jenkinsServer.isRunning()); 
		return jenkinsServer;
	}
}
