package org.code0.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**  
 * @Title: DemoConfiguration.java
 * @Package org.code0.configuration
 * @Description: DemoConfiguration.java
 * @author Code0   
 * @date 2017年12月10日 下午3:57:46 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.code0.demo")
public class DemoConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * Configure View Resolver
	 */
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
	 *
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("messages");//Spring 将搜索应用程序类路径中一个名为messages.properties的文件
		return ms;
	}
}
