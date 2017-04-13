package com.order.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc �����Ĺ�����
 * @author ���
 *
 */
public class JdbcUtils {
	
	/**
	 * �ͷ�connection����
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
	 * �������ݿ��һ��Connection ����
	 * @return
	 */
	
	private static DataSource dataSource = null;
	//��Ϊֻ��Ҫһ������Դ���Է��ڴ����������ֻ��ִ��һ��
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	public static Connection getConnection() throws SQLException{
		
		return dataSource.getConnection();
	}
}