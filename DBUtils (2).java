package com.neuedu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
* @ClassName: DBUtils
* @Description: ���ݿ⹤����
* @author cps
* @date 2019��9��9�� ����2:55:49
*
*/
public class DBUtils {
	//��ȡ�����ļ�
	private static Properties prop;
	static {
		prop = new Properties();
		try {
			prop.load(DBUtils.class.getResourceAsStream("/mysql.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ��ȡ���ӵķ���
	public static Connection getConnection() {
		try {
			Class.forName(prop.getProperty("driverClass"));
			Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("psw"));
			if(null != connection) {
				return connection;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
		
		
		
		
		
		
		
		
		
	}
	//ͳһ�ر���Դ�ķ���
	public static void closeResource(ResultSet rs,Statement statement,Connection connection) {
		if(null!=rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(null!=connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
