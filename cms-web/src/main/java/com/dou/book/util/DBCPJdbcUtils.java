package com.dou.book.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * 
 * @author Administrator
 * DBCP链接池工具类
 *
 */

public class DBCPJdbcUtils {
	   
    //DataSource是DBCP的数据库连接池
    private static DataSource ds=null;
     
    //既然是工具类，那就是拿来就能用的，不用new它
    //这个静态代码块确保其内容只运行一次，这里在第一次调用的时候，获取一个工厂
    static{
        try{
            //读取资源文件
            Properties prop =new Properties();
            prop.load(DBCPJdbcUtils.class.getClassLoader().getResourceAsStream("dbcp_jdbc.properties"));
             
            //DBCP的连接池工厂
            BasicDataSourceFactory factory=new BasicDataSourceFactory();
            //通过这个工厂，我们获得一个根据资源文件配置的数据库连接池
            ds = factory.createDataSource(prop);            
             
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
     
    //返回一个数据库连接
    public static Connection getConnection() throws SQLException{
        //从DataSource中获取一个空闲得连接并返回给调用它的方法
        return ds.getConnection();
    }   
    public static DataSource getDS(){
    	return ds;
    }
}