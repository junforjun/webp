package com.webp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//	@Override
//    public  void  configureDefaultServletHandling ( DefaultServletHandlerConfigurer  configurer )  {
//        configurer . enable ();
//    }
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
	@Override
	public  void  addResourceHandlers ( ResourceHandlerRegistry  registry )  {
		System.out.println("----------------------------------------------------------");
//	    registry . addResourceHandler ( "/resources/static/**" )
//	            . addResourceLocations ( "classpath : /resources/static/" )
//	            . resourceChain ( false )  // 로컬 개발 환경에서는 false (캐시 없음) 시험 환경 및 프로젝션 환경에서는 true (캐시 있음)을 지정
//	            . addResolver ( new  VersionResourceResolver ()
//	                     . addContentVersionStrategy ( "/**" ));  // 콘텐츠 데이터의 MD5 해시 값에 따른 버전 관리 기능 사용
	    if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(
					CLASSPATH_RESOURCE_LOCATIONS);
		}
	    System.out.println("----------------------------------------------------------");

	}





}
