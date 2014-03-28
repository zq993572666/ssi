package com.dou.book.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationObjectSupport;

public class SpringUtils implements ApplicationContextAware{
public static ApplicationContext applicationContext;

@Override
public void setApplicationContext(ApplicationContext arg0)
		throws BeansException {
	applicationContext=arg0;
	
}
}