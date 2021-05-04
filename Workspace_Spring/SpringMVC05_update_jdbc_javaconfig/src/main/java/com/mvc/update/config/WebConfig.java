package com.mvc.update.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// ApplcationConfig
		// AnnotationConfigWebApplicationContext : configuration 어노테이션 걸려있는 애들을 찾아준다.
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ApplicationConfig.class);	
		
		// Listener
		servletContext.addListener(new ContextLoaderListener(applicationContext));
		
		// ServletConfig
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(ServletConfig.class);
		
		ServletRegistration.Dynamic dispatcherServlet =
				servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("*.do");
		
		// encodingFilter
		FilterRegistration.Dynamic filterRegistration =
				servletContext.addFilter("encodigFilter", new CharacterEncodingFilter("UTF-8", true));
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");
	}
	// 1. dispatcherTypes : 필터 매핑의 디스패처 유형. 기본 DispatcherType.REQUEST가 사용될 경우 null 
    // 2. isMatchAfter :  지정된 필터매핑이 선언된 필터 맵핑 후에 일치해야하는경우 true
    // FilterRegistration을 얻은 ServletContext의 선언된 필터 매핑 전에 일치해야 하는 경우 false
    // 3. urlPatterns : 필터 매핑의 URL 패턴
}
