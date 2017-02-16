package com.kaligandaki.rest;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Configuration
@EnableWebMvc	/** Enable Spring MVC */
@ComponentScan("com.kaligandaki.rest.controller")	/** Enable component scanning for controllers*/
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
		converters.add(new MappingJackson2HttpMessageConverter(
				new Jackson2ObjectMapperBuilder().serializationInclusion(Include.NON_NULL).indentOutput(true).build()));
		converters.add(new Jaxb2RootElementHttpMessageConverter());
	}
	
	
	/** Configure a JSP view resolver */
	/*@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);		
		return resolver;
	}*/
	
	
	/** Configure Static content handling */
	/*@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}*/
}
