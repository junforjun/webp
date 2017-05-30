package com.webp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig {

	 @Bean
	 public TemplateResolver templateResolver() {
	  ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	  templateResolver.setPrefix("/WEB-INF/templates/");
	  templateResolver.setSuffix(".html");
	  templateResolver.setTemplateMode("LEGACYHTML5");
	  templateResolver.setCacheable(false);
	  return templateResolver;
	 }

	 @Bean
	 public SpringTemplateEngine templateEngine() {
	  SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	  templateEngine.setTemplateResolver(templateResolver());
	  templateEngine.addDialect(new LayoutDialect());
	  return templateEngine;
	 }

	 @Bean
	 public ViewResolver viewResolver() {
	  ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	  viewResolver.setCharacterEncoding("UTF-8");
	  viewResolver.setTemplateEngine(templateEngine());
	  viewResolver.setOrder(1);
	  return viewResolver;
	 }

}
