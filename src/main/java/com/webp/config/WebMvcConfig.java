package com.webp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/static/" };

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:/index.html");
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**")
//				.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
//				.setCachePeriod(0)
//				.resourceChain(false)
//				.addResolver(new PathResourceResolver());
////		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
//	}

}
