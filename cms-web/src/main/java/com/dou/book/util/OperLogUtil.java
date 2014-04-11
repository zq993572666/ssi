package com.dou.book.util;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;


/**
 * 操作日志工具类
 * @author freeteam
 *2011-3-6
 */
public class OperLogUtil {
private static	DataSource dataSource;
static{
	dataSource=(DataSource) SpringUtils.getBean("dataSource");
}
	public static void log() throws SQLException{
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			throw new SQLException(e);
		}
	}
}
