package com.order.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

 







import com.opensymphony.xwork2.Result;
import com.order.db.JdbcUtils;


public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	
	/*ParamerterizedType 代表被参数化的类型，即增加了泛型限制的类型有如下的两个方法
	 * getRawType()返回没有泛型信息的原始类型
	 * getActualTypeArguments（）返回泛型参数的类型
	 * 
	 */
	
	public DAO(){
		Type superClass = getClass().getGenericSuperclass();	//获取此类的泛型类型	
		if (superClass instanceof ParameterizedType) {	//如果superClass 是ParameterizedType对象
			ParameterizedType parameterizedType = (ParameterizedType) superClass;	//强制类型转换
			
			Type [] typeArgs = parameterizedType.getActualTypeArguments();	//取得泛型类型的泛型参数
			if (typeArgs[0] instanceof Class) {		
				clazz = (Class<T>) typeArgs[0];	
			}
		}
	}
	private Class<T> clazz;
	
	/**
	 * 返回某一个字段的值，例如返回某一条记录的customerName，或者返回数据表中有多少条记录等
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql,Object ...args ){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql,new ScalarHandler(),args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	/**
	 * 返回对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ...args ){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection,sql,new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * 返回对应的T的实例的对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ...args ){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection,sql,new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	
	//卢保    分页查询
	
	
	public CachedRowSet findByPage(String sql, int pageNo,int pageSize){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			Statement stmt=connection.createStatement();
	 
	  
	ResultSet rs= stmt.executeQuery(sql);
	 
	 RowSetFactory factory=RowSetProvider.newFactory();
	 CachedRowSet caches=factory.createCachedRowSet();
	 caches.setPageSize(pageSize);
	 caches.populate(rs, (pageNo-1)*pageSize+1);
	 return caches;
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	/**
	 * 该方法封装了INSERT,DELETE,UPDATE操作
	 * @param sql	sql查询
	 * @param args	填充SQL查询的占位符
	 */
	public boolean update(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return false;
	}
}
