package com.dou.book.data.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
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
			/*String reg="[Vv][aA][Ll][Uu][Ee][Ss]?";
			Pattern p=Pattern.compile(reg);
			Matcher m=p.matcher(sql);
			boolean isFind=m.find();
			if(isFind){
				String[] sqlArr=sql.split(reg);
				
				//values前面的sql语句
				sqlArr[0]=sqlArr[0].trim();
				//values后面的sql语句
				sqlArr[1]=sqlArr[1].trim();
				String intoReg="\\s+[Ii][Nn][Tt][Oo]\\s+";
				Pattern intoP=Pattern.compile(intoReg);
				Matcher intoMatcher=	intoP.matcher(sqlArr[0]);
				if(intoMatcher.find()){
					String[] splitStrings=	sqlArr[0].split(intoReg);
				}else{
					throw new SQLException("sql语句里不包含into或INTO");
				}
			}else{
				throw new SQLException("sql语句里不包含value或values");
			}*/
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
