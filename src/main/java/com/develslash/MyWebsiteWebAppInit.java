package com.develslash;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebsiteWebAppInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(WebConfig.class);

        DispatcherServlet servlet = new DispatcherServlet(webAppContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
