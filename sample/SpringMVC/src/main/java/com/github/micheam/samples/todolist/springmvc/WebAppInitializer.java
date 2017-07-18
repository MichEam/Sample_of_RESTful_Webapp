package com.github.micheam.samples.todolist.springmvc;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("WebAppIntializer onStartup: start.");

		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		rootContext.refresh();

		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Create the dispatcher servlet's SpringMVC application context
		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(WebMvcConfig.class);
		mvcContext.setParent(rootContext);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcherServlet 
			= servletContext.addServlet("dispatcherServlet", new DispatcherServlet(mvcContext));

		dispatcherServlet.setLoadOnStartup(1);
		Set<String> mappingConflicts = dispatcherServlet.addMapping("/");

		// Check the servlet mappings
		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				System.out.println("[ERROR] Mapping conflict: " + s);
			}
			throw new IllegalStateException(
					"'webservice' cannot be mapped to '/'");
		}
		System.out.println("WebAppIntializer onStartup: end.");
	}
}
