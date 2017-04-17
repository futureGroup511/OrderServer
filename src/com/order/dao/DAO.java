package com.order.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	
	/*ParamerterizedType ���������������ͣ��������˷������Ƶ����������µ���������
	 * getRawType()����û�з�����Ϣ��ԭʼ����
	 * getActualTypeArguments�������ط��Ͳ���������
	 * 
	 */
	
	public DAO(){
		Type superClass = getClass().getGenericSuperclass();	//��ȡ����ķ�������	
		if (superClass instanceof ParameterizedType) {	//���superClass ��ParameterizedType����
			ParameterizedType parameterizedType = (ParameterizedType) superClass;	//ǿ������ת��
			
			Type [] typeArgs = parameterizedType.getActualTypeArguments();	//ȡ�÷������͵ķ��Ͳ���
			if (typeArgs[0] instanceof Class) {		
				clazz = (Class<T>) typeArgs[0];	
			}
		}
	}
	private Class<T> clazz;
	
	/**
	 * ����ĳһ���ֶε�ֵ�����緵��ĳһ����¼��customerName�����߷������ݱ����ж�������¼��
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
	 * ���ض�Ӧ��List
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
	 * ���ض�Ӧ��T��ʵ���Ķ���
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
	
	
	//¬��    ��ҳ��ѯ
	
	
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
	 * �÷�����װ��INSERT,DELETE,UPDATE����
	 * @param sql	sql��ѯ
	 * @param args	���SQL��ѯ��ռλ��
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
