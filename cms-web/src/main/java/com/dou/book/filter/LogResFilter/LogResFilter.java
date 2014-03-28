package com.dou.book.filter.LogResFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

import com.dou.book.data.pojo.User;

public class LogResFilter implements Filter {
    
    private final static double DEFAULT_USERID= 0.0;   
    
    @Override
    public void destroy() {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        //System.out.println("进入过滤器");
        HttpServletRequest req=(HttpServletRequest)request;  
        HttpSession session= req.getSession();  
       User user= (User) session.getAttribute("user");
        if (user==null){  
         
        } else{  
            //用户的id
            if (user.getUserId() != null&& !user.getUserId().equals("")){  
                MDC.put("userId",user.getUserId());  
            }  
            if(user.getUserName() != null&& !user.getUserName().equals(""))  
            {  
                MDC.put("userName", user.getUserName());  
            }  
        }  
       chain.doFilter(request, response);  
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}