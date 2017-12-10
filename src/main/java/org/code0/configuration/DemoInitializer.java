package org.code0.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**  
 * @Title: DemoInitializer.java
 * @Package org.code0.configuration
 * @Description: DemoInitializer.java
 * @author Code0   
 * @date 2017年12月10日 下午4:49:20 
 */
public class DemoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DemoConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}


}
