package com.dou.book.action;

import java.util.ArrayList;
import java.util.List;

import com.dou.book.data.pojo.Person;
import com.google.gson.Gson;

public class AndroidService extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8889886709198438224L;

	public void androidService() throws Exception {
		List<String> cities = new ArrayList<String>();
		cities.add("广州");
		cities.add("上海");
		cities.add("北京");
		cities.add("湖南");
		Gson gson = new Gson();
		String json = gson.toJson(cities);
		print(json);
	}

	public void login() {
		String name = httpServletRequest.getParameter("userName");
		String password = httpServletRequest.getParameter("pass");
		print(1);
	}
	public void getPersonList(){
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
		print(json);
	}
}
