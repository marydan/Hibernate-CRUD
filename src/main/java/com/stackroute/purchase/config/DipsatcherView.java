package com.stackroute.purchase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.stackroute.purchase")
public class DipsatcherView 
{

	 @Bean
	 public InternalResourceViewResolver viewresolver()
	 {
		 InternalResourceViewResolver isr=new InternalResourceViewResolver();
		 isr.setPrefix("/WEB-INF/views/");
		 isr.setSuffix(".jsp");
		 return isr;
	 }
	
}
