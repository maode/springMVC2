package org.code0.springmvc2.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**  
 * @Title: WebInitializer.java
 * @Package org.code0.configuration
 * @Description: 初始化器类 [取代web.xml]
 * @author Code0   
 * @date 2017年12月10日 下午4:49:20 
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{MvcConfiguration.class};
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
