package com.dou.book.data.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.spi.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;

import com.dou.book.util.DBCPJdbcUtils;


public class JDBCPoolAppender extends org.apache.log4j.jdbc.JDBCAppender {

	/**数据库连接对象*/ 
	@Autowired
	private static DataSource dataSource;
	protected Connection connection;  
	static{
		dataSource=DBCPJdbcUtils.getDS();
	}
	public JDBCPoolAppender() {  
		super();  
	}  
	 protected void execute(String sql) throws SQLException {

		    Connection con = null;
		   PreparedStatement stmt = null;
		 //  if(sql.matches(""))
String[] sqlArr=sql.split("VALUES");

		    try {
		        con = getConnection();

		        stmt = con.prepareStatement(sql);
		        stmt.executeUpdate(sql);
		    } finally {
		        if(stmt != null) {
		            stmt.close();
		        }
		        closeConnection(con);
		    }

		    //System.out.println("Execute: " + sql);
		  }
	@Override 
	protected void closeConnection(Connection con) {  
		try {  
			if (connection != null && !connection.isClosed())  
				connection.close();  
		} catch (SQLException e) {  
			errorHandler.error("Error closing connection", e, ErrorCode.GENERIC_FAILURE);  
		}  
	}  

	@Override 
	protected Connection getConnection() throws SQLException {  
		try {
			//connection=JdbcUtils.getConnection();
			connection=dataSource.getConnection();
		} catch (SQLException e) {  
			System.out.println(e.getMessage());  
			throw e;
		}  
		catch (Exception e) {  
			System.out.println(e.getMessage());  
			throw e;
		}  
		return connection;  
	}


}
