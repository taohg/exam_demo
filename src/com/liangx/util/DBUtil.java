package com.liangx.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("-------�������ݿ������ɹ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <Desc>��ȡ�����ļ���ȡ���ݿ�����</Desc>
	 * @return
	 */
	public static Connection getConn() {
		Properties ps = new Properties();
		Connection conn = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream("db.properties");
		
		String user = null;
		String password = null;
		String url = null;
		try {
			ps.load(in);
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			url = ps.getProperty("url");
			
			if(conn == null){
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("��ȡ���ݿ����ӳɹ�������");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void closeConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("-------�ѹر����ݿ�����...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		Connection conn = DBUtil.getConn();
		
	}
}
