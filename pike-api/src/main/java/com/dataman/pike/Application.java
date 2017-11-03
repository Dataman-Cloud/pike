package com.dataman.pike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableAsync
@EnableTransactionManagement
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
}