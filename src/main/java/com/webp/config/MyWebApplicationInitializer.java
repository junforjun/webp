package com.webp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        ServletRegistration.Dynamic registration = container.addServlet("default", new DispatcherServlet());

        System.out.println("---------------------------------------------------------------------------");
        registration.setLoadOnStartup(1);
        registration.addMapping("/css/**");
        registration.addMapping("/js/**");
    }

}
