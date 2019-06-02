package com.wisely.highlight_springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//此处为配置的一个jsp的视图控制器
@Configuration
@EnableWebMvc //开启springmvc支持，若无此句，重写WebMvcConfigurerAdapter无效
@ComponentScan("com.wisely.highlight_springmvc4")
//继承WebMvcConfigurerAdapter，重写其方法可对springmvc进行配置
public class MyMvcConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceHandlers指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
		registry.addResourceHandler("/asserts/**").addResourceLocations("classpath:/assertss/");
	}
}
