package com.dou.book.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.dou.book.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware,RequestAware,ServletResponseAware {
private HttpServletRequest httpServletRequest;
private HttpServletResponse httpServletResponse;


	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
public void objectToJsonString(Object object){
	httpServletResponse.setCharacterEncoding("UTF-8"); 
	httpServletResponse.setContentType("application/json");  
	    try {
			String jsonString=JsonUtil.objectToJson(object);
			httpServletResponse.getWriter().print(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	httpServletResponse=arg0;
}
public void setRequest(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
	
}
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	httpServletRequest=arg0;
	
}
}
