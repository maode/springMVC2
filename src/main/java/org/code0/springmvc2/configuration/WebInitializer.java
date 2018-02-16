package org.code0.springmvc2.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
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

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		super.onStartup(servletContext);
		//自定义RESTful方法过滤器
		FilterRegistration.Dynamic hiddenHttpMethodFilter=servletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter());
		hiddenHttpMethodFilter.addMappingForServletNames(null, true, super.getServletName());
		//字符编码过滤器【防乱码】
		FilterRegistration.Dynamic encodingFilter=servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter("UTF-8",true));
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
		//session生命周期交给servlet管理解决懒加载异常问题
//		FilterRegistration.Dynamic sessionViewFilter=servletContext.addFilter("openSessionInViewFilter", new OpenSessionInViewFilter());
//		sessionViewFilter.setInitParameter("singleSession", "true");
//		sessionViewFilter.addMappingForUrlPatterns(null, true, "/");
		
	}

	

}
