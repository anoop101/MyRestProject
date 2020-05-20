package com.kaligandaki.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class KaligandakiRestWebXML implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//registering ContextLoaderListener
		servletContext.addListener(getRootContext());

		//registering DispatcherServlet
		Dynamic myServlet = servletContext.addServlet("dispatcherServlet", getDispatcherServlet());
		myServlet.addMapping("/");
		myServlet.setLoadOnStartup(1);
	}
	
	//hey this is also trisl yest
	/**
	 * Registering ContextLoaderListener
	 * @return
	 */
	private ContextLoaderListener getRootContext(){
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootContext);
		return contextLoaderListener;
	}
	
	/**
	 * Registering Dispatcher servlet
	 * @return
	 */
	private DispatcherServlet getDispatcherServlet(){
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebConfig.class);
		return new DispatcherServlet(webContext);
	}

}
