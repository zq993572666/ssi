package com.dou.book.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dou.book.util.JsonUtil;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,
		RequestAware, ServletResponseAware,ServletContextAware {
	protected HttpServletRequest httpServletRequest;
	protected HttpServletResponse httpServletResponse;
	protected ServletContext servletContext;
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void objectToJsonString(Object object) {
		httpServletResponse.setContentType("text/html;charset=utf-8");
		try {
			String jsonString = JsonUtil.objectToJson(object);
			httpServletResponse.getWriter().print(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void print(Object object){
		httpServletResponse.setContentType("text/html;charset=utf-8");
		    try {
				httpServletResponse.getWriter().print(object);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	public void printJsonString(Object object){
		httpServletResponse.setContentType("text/html;charset=utf-8");
		    try {
		    	Gson gson = new Gson();
		    	String json = gson.toJson(object);
				httpServletResponse.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		httpServletResponse = arg0;
	}

	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		httpServletRequest = arg0;

	}

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		servletContext=context;
	}
	public Object getBeanByClassNameStr(String beanName){
		Object obj=(Object)WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getBean(beanName);
		return obj;
	}
}
