package com.dou.book.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dou.book.data.pojo.Person;
import com.dou.book.data.pojo.User;
import com.dou.book.util.OperLogUtil;
import com.dou.book.util.SpringUtils;
import com.google.gson.Gson;

public class AndroidService  {
	/**
	 * 
	 */
	static Logger logger = Logger.getLogger(AndroidService.class);
	private static final long serialVersionUID = 8889886709198438224L;
	public void androidService() throws Exception {
		List<String> cities = new ArrayList<String>();
		cities.add("广州");
		cities.add("上海");
		cities.add("北京");
		cities.add("湖南");
		Gson gson = new Gson();
		String json = gson.toJson(cities);
	}
	public String  toAndroidService() throws Exception {
		return "toAndroidService";
		
	}
	public void login() throws SQLException {
		//DataSource ds=(DataSource) SpringUtils.getBean("dataSource");
		OperLogUtil.log();
		//将要插入log4j中的信息放入log中
		 MDC.put("userId", "123");
		 MDC.put("userName", "zhaoqun");
		 MDC.put("operation", "添加");
		 logger.info("select * from log where logid=111");
		 
	}
	public void getPersonList(){
		// ServletContext servletContext = ServletActionContext.getServletContext();  
	//	HttpSession httpSession=getHttpServletRequest().getSession();
		User user=new User();
		user.setUserId("123");
		user.setUserName("zhaoqun");
		//httpSession.setAttribute("user", user);
		List<Person> cities = new ArrayList<Person>();
		Person person1=new Person();
		person1.setId("1");
		cities.add(person1);
		person1.setName("zhaoqun");
		Person person2=new Person();
		person2.setId("2");
		person2.setName("理性来");
		cities.add(person2);
		Gson gson = new Gson();
		String json = gson.toJson(cities);
	//	print(json);
	}
}
