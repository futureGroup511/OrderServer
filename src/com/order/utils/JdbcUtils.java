package com.order.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc 操作的工具类
 * @author 秋放
 *
 */
public class JdbcUtils {
	
	/**
	 * 释放connection连接
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		try {
			if (connection!=null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 返回数据库的一个Connection 对象
	 * @return
	 */
	
	private static DataSource dataSource = null;
	//因为只想要一个数据源所以放在代码块中这样只被执行一次
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	public static Connection getConnection() throws SQLException{
		
		return dataSource.getConnection();
	}
}
