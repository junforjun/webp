package com.webp;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * Main boot
 *
 * @author KIM
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class webp {

	public static void main(String[] args) {
		SpringApplication.run(webp.class, args);
	}

	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}
}
