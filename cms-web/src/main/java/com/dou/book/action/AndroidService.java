package com.dou.book.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		String name = httpServletRequest.getParameter("name");
		String password = httpServletRequest.getParameter("password");
		List<String> cities = new ArrayList<String>();
		cities.add(name);
		cities.add(password);
		Gson gson = new Gson();
		String json = gson.toJson(cities);
		print(json);
	}
}
